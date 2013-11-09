package com.flagleader.repository.b;

import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.RSClassLoader;
import com.flagleader.engine.impl.RuleContextContainer;
import com.flagleader.engine.impl.XmlRuleSetFile;
import com.flagleader.repository.e.d;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.JspUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;

public class b extends RuleEngineFactory
{
  private HashMap a = new HashMap();
  private HashMap b = new HashMap();
  private c c = null;

  private Thread b()
  {
    return Thread.currentThread();
  }

  public b()
  {
    c();
  }

  private void c()
  {
    if ((Property.getInstance().getUpdateInternateTime() > 0L) && ((this.c == null) || (this.c.a())))
    {
      this.c = new c(this, b());
      this.c.start();
    }
  }

  public RuleEngine getRuleEngine()
  {
    return new a(this);
  }

  public IRuleContext getContext(String paramString, boolean paramBoolean)
  {
    IRuleContext localIRuleContext = null;
    if (((Property.getInstance().getUpdateInternateTime() == 0L) || (paramBoolean)) && (a(paramString)))
      localIRuleContext = a(paramString, b(paramString));
    if (localIRuleContext == null)
      synchronized (this)
      {
        localIRuleContext = (IRuleContext)this.a.get(paramString);
        if (localIRuleContext == null)
        {
          localIRuleContext = a(paramString, b(paramString));
          if (localIRuleContext != null)
            c();
        }
      }
    if (localIRuleContext != null)
      return localIRuleContext.deepClone();
    return null;
  }

  private boolean a(String paramString)
  {
    RuleContextContainer localRuleContextContainer = (RuleContextContainer)this.b.get(paramString);
    if (localRuleContextContainer == null)
      return true;
    URL localURL = b(paramString);
    if (localURL == null)
      throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }));
    try
    {
      if ((localURL != null) && (JspUtil.getUrlLastTime(localURL) == localRuleContextContainer.getLastModified()))
        return false;
    }
    catch (IOException localIOException)
    {
      throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }), localIOException);
    }
    return true;
  }

  private synchronized IRuleContext a(String paramString, URL paramURL)
  {
    RuleContextContainer localRuleContextContainer = b(paramString, paramURL);
    if (localRuleContextContainer != null)
    {
      IRuleContext localIRuleContext = a(localRuleContextContainer.getBytecodes());
      localIRuleContext.init();
      this.a.put(paramString, localIRuleContext);
      this.b.put(paramString, localRuleContextContainer);
      return localIRuleContext;
    }
    throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }));
  }

  public void stopUpdateThreads()
  {
    if ((this.c != null) && (this.c.isAlive()))
    {
      this.c.a(true);
      this.c = null;
    }
  }

  public void setUpdateInternalTime(int paramInt)
  {
    Property.getInstance().setUpdateInternateTime(paramInt);
    if (paramInt == 0)
    {
      this.c.interrupt();
      this.c = null;
    }
    else if (this.c != null)
    {
      this.c = new c(this, b());
      this.c.start();
    }
  }

  private URL b(String paramString)
  {
    String str = "";
    if (!XmlRuleSetFile.verifyPackageFileName(paramString))
    {
      str = paramString.replace('.', '/');
      str = str + ".rpk";
    }
    else
    {
      str = paramString.substring(0, paramString.lastIndexOf(".")).replace('.', '/') + ".rpk";
    }
    if (getRuleBasePath() != null)
      try
      {
        File localFile = new File(getRuleBasePath(), str);
        if (localFile.exists())
          return localFile.toURL();
      }
      catch (Exception localException)
      {
      }
    URL localURL = getClassLoader().getResource(str);
    if (localURL != null)
      return localURL;
    return getClass().getClassLoader().getResource(str);
  }

  private RuleContextContainer b(String paramString, URL paramURL)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +24 -> 25
    //   4: new 10	com/flagleader/engine/RuleEngineException
    //   7: dup
    //   8: ldc 5
    //   10: iconst_1
    //   11: anewarray 36	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 51	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 58	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual 76	com/flagleader/repository/b/b:a	(Ljava/net/URL;)Ljava/lang/Object;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +28 -> 60
    //   35: aload_3
    //   36: instanceof 13
    //   39: ifeq +21 -> 60
    //   42: aload_3
    //   43: checkcast 13	com/flagleader/engine/impl/RuleContextContainer
    //   46: astore 4
    //   48: aload 4
    //   50: aload_2
    //   51: invokestatic 97	com/flagleader/util/JspUtil:getUrlLastTime	(Ljava/net/URL;)J
    //   54: invokevirtual 67	com/flagleader/engine/impl/RuleContextContainer:setLastModified	(J)V
    //   57: aload 4
    //   59: areturn
    //   60: aconst_null
    //   61: areturn
    //   62: astore_3
    //   63: new 10	com/flagleader/engine/RuleEngineException
    //   66: dup
    //   67: ldc 5
    //   69: iconst_1
    //   70: anewarray 36	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 51	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 59	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	59	62	java/lang/Exception
  }

  private boolean c(String paramString)
  {
    return b(paramString) != null;
  }

  private IRuleContext a(byte[] paramArrayOfByte)
  {
    try
    {
      Class localClass = null;
      localClass = new RSClassLoader(getClassLoader()).loadClassFromBytes(paramArrayOfByte);
      Constructor localConstructor = localClass.getConstructor(new Class[0]);
      return (IRuleContext)localConstructor.newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
    }
    throw new RuleEngineException(MessageUtil.getString("loadRuleContext.error"), localException);
  }

  public String a()
  {
    if (!StringUtil.isEmpty(getRuleBasePath()))
      return getRuleBasePath();
    String str = Property.getInstance().getRuleEngineClassDir();
    if ((str == null) || (str.length() == 0))
      str = SystemUtils.JAVA_IO_TMPDIR;
    return str;
  }

  protected Object a(URL paramURL)
  {
    RulePackage localRulePackage = (RulePackage)new d().load(paramURL.openStream());
    String str1 = m.a().i().b(localRulePackage);
    com.flagleader.repository.a.c localc = new com.flagleader.repository.a.c();
    String str2 = localc.a(a(), "", localRulePackage.getExeRulePackageName(), localRulePackage.getMainVersion(), localRulePackage.getRuleClassName(), str1, true);
    if ((str2 == null) || (str2.length() == 0))
    {
      Object localObject = null;
      FileInputStream localFileInputStream = new FileInputStream(localc.c());
      ObjectInputStream localObjectInputStream = new ObjectInputStream(localFileInputStream);
      localObject = localObjectInputStream.readObject();
      localObjectInputStream.close();
      localFileInputStream.close();
      return localObject;
    }
    throw new RuleEngineException(str2);
  }

  public void resetClassLoader()
  {
    super.resetClassLoader();
    this.b.clear();
    this.a.clear();
  }

  public List getAllRuleNames()
  {
    Iterator localIterator = this.a.keySet().iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return localArrayList;
  }

  public IRuleContext getContext(String paramString)
  {
    IRuleContext localIRuleContext = (IRuleContext)this.a.get(paramString);
    if (localIRuleContext == null)
      localIRuleContext = a(paramString, b(paramString));
    return localIRuleContext;
  }

  public void deletePack(String paramString)
  {
    URL localURL = b(paramString);
    if (localURL != null)
    {
      File localFile = new File(localURL.getFile());
      if (localFile.exists())
      {
        localFile.delete();
        this.b.remove(paramString);
        this.a.remove(paramString);
      }
    }
    super.deletePack(paramString);
  }

  public long getRuleLastModified(String paramString)
  {
    RuleContextContainer localRuleContextContainer = (RuleContextContainer)this.b.get(paramString);
    if (localRuleContextContainer != null)
      return localRuleContextContainer.getLastModified();
    return 0L;
  }

  public void clearRules()
  {
    this.b.clear();
    this.a.clear();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.b.b
 * JD-Core Version:    0.6.0
 */