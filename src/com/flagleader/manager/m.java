package com.flagleader.manager;

import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineParameter;
import com.flagleader.engine.RuleEngineParameters;
import com.flagleader.engine.impl.RSClassLoader;
import com.flagleader.engine.impl.RuleContextContainer;
import com.flagleader.engine.impl.XmlRuleSetFile;
import com.flagleader.util.JspUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class m extends RuleEngineFactory
{
  private Hashtable a = new Hashtable();
  private Hashtable b = new Hashtable();

  public RuleEngine getRuleEngine()
  {
    return new j(this);
  }

  public IRuleContext getContext(String paramString, boolean paramBoolean)
  {
    IRuleContext localIRuleContext = null;
    if (b(paramString))
      localIRuleContext = a(paramString, c(paramString));
    if (localIRuleContext == null)
      localIRuleContext = a(paramString);
    if (localIRuleContext != null)
      return localIRuleContext.deepClone();
    return null;
  }

  private synchronized IRuleContext a(String paramString)
  {
    IRuleContext localIRuleContext = (IRuleContext)this.a.get(paramString);
    if (localIRuleContext == null)
    {
      localIRuleContext = (IRuleContext)this.a.get(paramString);
      if (localIRuleContext == null)
        localIRuleContext = a(paramString, c(paramString));
    }
    return localIRuleContext;
  }

  private boolean b(String paramString)
  {
    RuleContextContainer localRuleContextContainer = (RuleContextContainer)this.b.get(paramString);
    if (localRuleContextContainer == null)
      return true;
    URL localURL = c(paramString);
    if (localURL == null)
      throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }));
    try
    {
      URLConnection localURLConnection = localURL.openConnection();
      long l = localURLConnection.getLastModified();
      localURLConnection.getInputStream().close();
      if (l == localRuleContextContainer.getLastModified())
        return false;
    }
    catch (IOException localIOException)
    {
      throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }), localIOException);
    }
    return true;
  }

  private IRuleContext a(String paramString, URL paramURL)
  {
    RuleContextContainer localRuleContextContainer = b(paramString, paramURL);
    if (localRuleContextContainer != null)
    {
      IRuleContext localIRuleContext1 = a(localRuleContextContainer.getBytecodes());
      getParameters().registerParameter(paramString, new RuleEngineParameter(localIRuleContext1));
      IRuleContext localIRuleContext2 = (IRuleContext)this.a.get(paramString);
      this.a.put(paramString, localIRuleContext1);
      this.b.put(paramString, localRuleContextContainer);
      if (localIRuleContext2 != null)
        localIRuleContext2.destroy();
      localIRuleContext1.init();
      return localIRuleContext1;
    }
    throw new RuleEngineException(MessageUtil.format("loadRuleContextContainer.error", new String[] { paramString }));
  }

  public void stopUpdateThreads()
  {
  }

  public void setUpdateInternalTime(int paramInt)
  {
    Property.getInstance().setUpdateInternateTime(paramInt);
  }

  private URL c(String paramString)
  {
    String str = "";
    if (!XmlRuleSetFile.verifyFileName(paramString))
    {
      str = paramString.replace('.', '/');
      str = str + ".rsc";
    }
    else
    {
      str = paramString.substring(0, paramString.lastIndexOf(".")).replace('.', '/') + ".rsc";
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
    //   11: anewarray 29	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: aastore
    //   18: invokestatic 41	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 46	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: aload_2
    //   26: invokestatic 62	com/flagleader/manager/m:a	(Ljava/net/URL;)Ljava/lang/Object;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull +28 -> 59
    //   34: aload_3
    //   35: instanceof 15
    //   38: ifeq +21 -> 59
    //   41: aload_3
    //   42: checkcast 15	com/flagleader/engine/impl/RuleContextContainer
    //   45: astore 4
    //   47: aload 4
    //   49: aload_2
    //   50: invokestatic 69	com/flagleader/util/JspUtil:getUrlLastTime	(Ljava/net/URL;)J
    //   53: invokevirtual 57	com/flagleader/engine/impl/RuleContextContainer:setLastModified	(J)V
    //   56: aload 4
    //   58: areturn
    //   59: aconst_null
    //   60: areturn
    //   61: astore_3
    //   62: new 10	com/flagleader/engine/RuleEngineException
    //   65: dup
    //   66: ldc 5
    //   68: iconst_1
    //   69: anewarray 29	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: invokestatic 41	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: aload_3
    //   80: invokespecial 47	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: athrow
    //   84: astore_3
    //   85: new 10	com/flagleader/engine/RuleEngineException
    //   88: dup
    //   89: ldc 5
    //   91: iconst_1
    //   92: anewarray 29	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: invokestatic 41	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: aload_3
    //   103: invokespecial 47	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	58	61	java/io/IOException
    //   25	58	84	java/lang/ClassNotFoundException
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

  protected static Object a(URL paramURL)
  {
    Object localObject = null;
    InputStream localInputStream = paramURL.openStream();
    ObjectInputStream localObjectInputStream = new ObjectInputStream(localInputStream);
    localObject = localObjectInputStream.readObject();
    localObjectInputStream.close();
    localInputStream.close();
    return localObject;
  }

  protected static Object a(InputStream paramInputStream)
  {
    Object localObject = null;
    ObjectInputStream localObjectInputStream = new ObjectInputStream(paramInputStream);
    localObject = localObjectInputStream.readObject();
    localObjectInputStream.close();
    paramInputStream.close();
    return localObject;
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
    return a(paramString);
  }

  public void deletePack(String paramString)
  {
    URL localURL = c(paramString);
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
 * Qualified Name:     com.flagleader.manager.m
 * JD-Core Version:    0.6.0
 */