package com.flagleader.repository.d;

import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.impl.RSClassLoader;
import com.flagleader.engine.impl.RuleContextContainer;
import com.flagleader.engine.impl.XmlRuleSetFile;
import com.flagleader.util.JspUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.net.URL;

public class w
{
  private RuleEngineClassLoader a = null;

  public IRuleContext a(URL paramURL)
  {
    Object localObject = b(paramURL);
    if ((localObject != null) && ((localObject instanceof RuleContextContainer)))
    {
      RuleContextContainer localRuleContextContainer = (RuleContextContainer)localObject;
      return b(localRuleContextContainer.getBytecodes());
    }
    return null;
  }

  public RuleContextContainer a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 41	com/flagleader/repository/d/w:b	(Ljava/lang/String;)Ljava/net/URL;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull +24 -> 31
    //   10: new 9	com/flagleader/engine/RuleEngineException
    //   13: dup
    //   14: ldc 5
    //   16: iconst_1
    //   17: anewarray 23	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 29	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokespecial 33	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_2
    //   32: invokestatic 42	com/flagleader/repository/d/w:b	(Ljava/net/URL;)Ljava/lang/Object;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +28 -> 65
    //   40: aload_3
    //   41: instanceof 11
    //   44: ifeq +21 -> 65
    //   47: aload_3
    //   48: checkcast 11	com/flagleader/engine/impl/RuleContextContainer
    //   51: astore 4
    //   53: aload 4
    //   55: aload_2
    //   56: invokestatic 44	com/flagleader/util/JspUtil:getUrlLastTime	(Ljava/net/URL;)J
    //   59: invokevirtual 38	com/flagleader/engine/impl/RuleContextContainer:setLastModified	(J)V
    //   62: aload 4
    //   64: areturn
    //   65: aconst_null
    //   66: areturn
    //   67: astore_3
    //   68: new 9	com/flagleader/engine/RuleEngineException
    //   71: dup
    //   72: ldc 5
    //   74: iconst_1
    //   75: anewarray 23	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_1
    //   81: aastore
    //   82: invokestatic 29	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   85: aload_3
    //   86: invokespecial 34	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_3
    //   91: new 9	com/flagleader/engine/RuleEngineException
    //   94: dup
    //   95: ldc 5
    //   97: iconst_1
    //   98: anewarray 23	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: invokestatic 29	com/flagleader/engine/MessageUtil:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   108: aload_3
    //   109: invokespecial 34	com/flagleader/engine/RuleEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   31	64	67	java/io/IOException
    //   31	64	90	java/lang/ClassNotFoundException
  }

  private IRuleContext b(byte[] paramArrayOfByte)
  {
    try
    {
      Class localClass = null;
      localClass = new RSClassLoader(a()).loadClassFromBytes(paramArrayOfByte);
      Constructor localConstructor = localClass.getConstructor(new Class[0]);
      return (IRuleContext)localConstructor.newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
    }
    throw new RuleEngineException(MessageUtil.getString("loadRuleContext.error"), localException);
  }

  public URL b(String paramString)
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
    URL localURL = a().getResource(str);
    if (localURL != null)
      return localURL;
    return getClass().getClassLoader().getResource(str);
  }

  public boolean c(String paramString)
  {
    return b(paramString) != null;
  }

  public IRuleContext a(byte[] paramArrayOfByte)
  {
    try
    {
      Class localClass = null;
      localClass = new RSClassLoader(a()).loadClassFromBytes(paramArrayOfByte);
      Constructor localConstructor = localClass.getConstructor(new Class[0]);
      return (IRuleContext)localConstructor.newInstance(new Object[0]);
    }
    catch (Throwable localThrowable)
    {
    }
    throw new RuleEngineException(MessageUtil.getString("loadRuleContext.error"), localThrowable);
  }

  protected static Object b(URL paramURL)
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

  public RuleEngineClassLoader a()
  {
    if (this.a == null)
      this.a = new RuleEngineClassLoader(getClass().getClassLoader());
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.w
 * JD-Core Version:    0.6.0
 */