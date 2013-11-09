package com.flagleader.repository.lang.b;

import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.impl.RuleContextContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class d
  implements a
{
  com.flagleader.repository.lang.h a = i.d();
  com.flagleader.repository.a.c b = new com.flagleader.repository.a.c();

  public void a(IRulePackage paramIRulePackage, PrintWriter paramPrintWriter)
  {
    j localj = new j(paramPrintWriter);
    localj.b(false);
    localj.c(paramIRulePackage);
    localj.i();
  }

  public String a(IPackageElement paramIPackageElement)
  {
    j localj = new j();
    localj.b(false);
    return localj.b(paramIPackageElement);
  }

  public com.flagleader.repository.lang.c a()
  {
    t localt = new t();
    return localt;
  }

  public String a(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleTree))
    {
      localt = new t();
      localt.a(true);
      localt.b(false);
      return localt.a((IRuleTree)paramIElement);
    }
    t localt = new t();
    localt.a(true);
    localt.b(false);
    return localt.a(paramIElement);
  }

  public List b(IPackageElement paramIPackageElement)
  {
    if ((paramIPackageElement instanceof IRulePackage))
      return ((IRulePackage)paramIPackageElement).getErrorList();
    List localList = new com.flagleader.repository.e.h().c(paramIPackageElement);
    localList.addAll(new com.flagleader.repository.e.h().c(paramIPackageElement.getEnvionment()));
    return localList;
  }

  public String a(File paramFile, String paramString)
  {
    return this.b.a(paramFile, paramString);
  }

  public File a(IRuleClass paramIRuleClass, String paramString, boolean paramBoolean)
  {
    File localFile1 = new File(paramString);
    if (paramIRuleClass.getPackageName().length() > 0)
      localFile1 = new File(paramString, paramIRuleClass.getPackageName().replace('.', File.separatorChar));
    File localFile2 = new File(localFile1, paramIRuleClass.getClassName() + ".java");
    if (!localFile2.exists())
    {
      localFile2.getParentFile().mkdirs();
      localFile2.createNewFile();
    }
    if ((paramBoolean) && ((paramIRuleClass instanceof IRuleTree)) && (((IRuleTree)paramIRuleClass).getMainPackage() != null))
      ((IRuleTree)paramIRuleClass).setRunBreak(true);
    try
    {
      j localj = new j(new PrintWriter(new FileWriter(localFile2)));
      localj.c(paramIRuleClass);
      localj.i();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    finally
    {
      if ((paramBoolean) && ((paramIRuleClass instanceof IRuleTree)) && (((IRuleTree)paramIRuleClass).getMainPackage() != null))
        ((IRuleTree)paramIRuleClass).setRunBreak(false);
    }
    return localFile2;
  }

  public File a(IRuleClass paramIRuleClass, boolean paramBoolean, String paramString)
  {
    File localFile1 = new File(paramString);
    if (paramIRuleClass.getPackageName().length() > 0)
      localFile1 = new File(paramString, paramIRuleClass.getPackageName().replace('.', File.separatorChar));
    File localFile2 = new File(localFile1, paramIRuleClass.getClassName() + ".java");
    File localFile3 = new File(localFile1, paramIRuleClass.getClassName() + ".class");
    File localFile4 = new File(localFile1, paramIRuleClass.getFileName() + ".rsc");
    try
    {
      RuleContextContainer localRuleContextContainer = new RuleContextContainer(com.flagleader.repository.a.c.a(localFile3));
      localRuleContextContainer.setLastModified(localFile3.lastModified());
      com.flagleader.repository.a.c.a(localRuleContextContainer, localFile4);
      File localFile5 = localFile4;
      return localFile5;
    }
    catch (RuleEngineException localRuleEngineException)
    {
      throw localRuleEngineException;
    }
    finally
    {
      if (paramBoolean)
      {
        if (localFile2.exists())
          localFile2.delete();
        if (localFile3.exists())
          localFile3.delete();
      }
    }
    throw localObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.d
 * JD-Core Version:    0.6.0
 */