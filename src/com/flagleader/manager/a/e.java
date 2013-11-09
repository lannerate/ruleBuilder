package com.flagleader.manager.a;

import com.flagleader.manager.d.c;
import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.d;
import com.flagleader.repository.e.o;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.PackageHistory;
import com.flagleader.repository.tree.RuleHistory;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class e
{
  r a = null;

  public e(r paramr)
  {
    this.a = paramr;
  }

  public void a(IRulePackage paramIRulePackage)
  {
    if (paramIRulePackage.isModified())
    {
      this.a.b().showQuestion(c.a("toclose.PackageManager", new String[] { paramIRulePackage.getDisplayName() }), new h(this, paramIRulePackage));
    }
    else
    {
      paramIRulePackage.clearAutoSave();
      paramIRulePackage.disposeAndUpdate();
    }
  }

  public void b(IRulePackage paramIRulePackage)
  {
    Object localObject;
    if ((paramIRulePackage.needRecompile()) && (com.flagleader.manager.d.b.a().g()))
    {
      this.a.l().a(paramIRulePackage, paramIRulePackage.getCompilePath(), com.flagleader.manager.d.b.a().z(), true);
      if ((this.a.b().isWebEditor()) && (paramIRulePackage.getRuletypeid() == 5) && (!StringUtil.isEmpty(com.flagleader.manager.d.b.a(this.a.d()).H())) && (com.flagleader.manager.d.b.a(this.a.d()).H().indexOf("readrule") > 0))
      {
        localObject = StringUtil.replaceAll(com.flagleader.manager.d.b.a(this.a.d()).H(), "readrule", "deployrule");
        this.a.l().a(paramIRulePackage, (String)localObject, true);
      }
    }
    if (com.flagleader.manager.d.b.a().q())
    {
      localObject = paramIRulePackage.getAcceptChildren(new f(this));
      while (((Iterator)localObject).hasNext())
        this.a.l().a((IPage)((Iterator)localObject).next(), com.flagleader.manager.d.b.a().e(), com.flagleader.manager.d.b.a().A(), false);
    }
    boolean bool = paramIRulePackage.isModified();
    paramIRulePackage.save();
    if ((bool) && (com.flagleader.manager.d.b.a().D()))
      this.a.l().b(paramIRulePackage);
    this.a.j().c(c.a("HasBeenSaved", new String[] { paramIRulePackage.getFilePathName() }));
  }

  public void c(IRulePackage paramIRulePackage)
  {
    if (paramIRulePackage.canDeleteFile())
      this.a.b().showQuestion(c.b("to_delete_file"), new i(this, paramIRulePackage));
    paramIRulePackage.disposeAndUpdate();
  }

  public void a(IRuleRepository paramIRuleRepository, IRulePackage paramIRulePackage)
  {
    IRulePackage localIRulePackage = paramIRuleRepository.exitsPackage(paramIRulePackage.getExeRulePackageName());
    if (localIRulePackage != null)
      this.a.b().showQuestion(c.b("importPackError.importpackage"), new j(this, localIRulePackage));
    else
      paramIRuleRepository.addChildElement(paramIRulePackage);
  }

  public IRulePackage a(File paramFile)
  {
    RulePackage localRulePackage = (RulePackage)new d().load(paramFile);
    if (!m.a().a(localRulePackage.getExeRulePackageName()))
    {
      this.a.b().showError(c.b("noright.importpackage"));
      return null;
    }
    if (m.a().e() == 1)
      localRulePackage.setEdittype(RulePackage.EDITER);
    localRulePackage.setFilePathName(paramFile.getAbsolutePath());
    Object localObject;
    if (this.a.d() != null)
    {
      localObject = this.a.d().exitsPackage(localRulePackage.getExeRulePackageName());
      if (localObject != null)
      {
        this.a.b().showError(c.b("exitsPackError.importpackage"));
        return null;
      }
      this.a.d().addChildElement(localRulePackage);
    }
    else
    {
      localObject = new RuleRepository();
      this.a.a((IRuleRepository)localObject);
      com.flagleader.manager.d.b.a().a((RuleRepository)localObject);
      ((RuleRepository)localObject).addRulePackage(localRulePackage);
    }
    if (!paramFile.canWrite())
      localRulePackage.setLocked(true);
    return (IRulePackage)localRulePackage;
  }

  public void a(IRulePackage paramIRulePackage, String paramString)
  {
    try
    {
      String str = new o().b(paramIRulePackage);
      FileUtil.saveToFile(paramString, str, o.b(str));
      this.a.j().c(c.a("htmlcreated.PackageManager", new String[] { paramString }));
    }
    catch (IOException localIOException)
    {
      this.a.j().a(localIOException.getMessage(), localIOException);
    }
  }

  public boolean d(IRulePackage paramIRulePackage)
  {
    if (paramIRulePackage.needCheck())
    {
      paramIRulePackage.setError(new com.flagleader.repository.e.h().c(paramIRulePackage));
      this.a.m().a(paramIRulePackage);
    }
    boolean bool = paramIRulePackage.hasError();
    return bool;
  }

  public void e(IRulePackage paramIRulePackage)
  {
    Iterator localIterator1 = paramIRulePackage.getChildrenIterator();
    while (localIterator1.hasNext())
    {
      localObject = localIterator1.next();
      if (!(localObject instanceof PackageHistory))
        continue;
      ((PackageHistory)localObject).disposeAndUpdate();
    }
    Object localObject = new PackageHistory();
    Iterator localIterator2 = paramIRulePackage.getAcceptElements(new g(this));
    while (localIterator2.hasNext())
    {
      IRule localIRule1 = (IRule)localIterator2.next();
      RuleHistory localRuleHistory = new RuleHistory();
      localRuleHistory.setUuid(localIRule1.getUuid());
      localRuleHistory.setDisplayName(localIRule1.toString());
      IRule localIRule2 = (IRule)localIRule1.deepClone();
      localIRule2.setModified(false);
      localIRule2.setModifyTime(localIRule2.getModifyTime());
      localRuleHistory.addChildElement(localIRule2);
      ((PackageHistory)localObject).addChildElement(localRuleHistory);
    }
    paramIRulePackage.addChildElement((IElement)localObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.e
 * JD-Core Version:    0.6.0
 */