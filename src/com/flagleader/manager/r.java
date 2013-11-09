package com.flagleader.manager;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.a.a.e;
import com.flagleader.manager.c.a.D;
import com.flagleader.manager.c.a.J;
import com.flagleader.manager.c.a.Q;
import com.flagleader.manager.c.a.aL;
import com.flagleader.manager.c.a.aX;
import com.flagleader.manager.c.a.ac;
import com.flagleader.manager.c.a.ad;
import com.flagleader.manager.c.a.ag;
import com.flagleader.manager.c.a.al;
import com.flagleader.manager.c.a.ar;
import com.flagleader.manager.c.a.aw;
import com.flagleader.manager.c.a.bc;
import com.flagleader.manager.c.a.bi;
import com.flagleader.manager.c.a.bj;
import com.flagleader.manager.c.a.z;
import com.flagleader.manager.c.b.p;
import com.flagleader.manager.c.d.V;
import com.flagleader.manager.c.d.W;
import com.flagleader.manager.c.d.Z;
import com.flagleader.manager.c.d.aC;
import com.flagleader.manager.c.d.aE;
import com.flagleader.manager.c.d.aj;
import com.flagleader.manager.c.d.ak;
import com.flagleader.manager.c.d.k;
import com.flagleader.manager.c.d.o;
import com.flagleader.manager.c.d.w;
import com.flagleader.manager.c.d.x;
import com.flagleader.manager.c.d.y;
import com.flagleader.repository.d.v;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.export.AjaxPage;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.m;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleDBProject;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class r
  implements com.flagleader.repository.tree.an
{
  a a;
  com.flagleader.manager.builder.b b = null;
  private String f = null;
  private int g = 0;
  private int h = 0;
  private boolean i = false;
  private IRuleRepository j = null;
  private static IRuleRepository k = null;
  private t l;
  private n m;
  private com.flagleader.manager.a.b n;

  public r(com.flagleader.manager.builder.b paramb)
  {
    this.b = paramb;
    this.a = new a(this);
    this.l = new t(this);
    this.m = new n(this);
    this.n = new com.flagleader.manager.a.b(this);
  }

  public String a()
  {
    return this.f;
  }

  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.f = paramString;
    this.h = paramInt1;
    this.g = paramInt2;
    b().showLogin(paramString);
  }

  public com.flagleader.manager.builder.b b()
  {
    return this.b;
  }

  public a c()
  {
    return this.a;
  }

  public IRuleRepository d()
  {
    return this.j;
  }

  public void a(File paramFile)
  {
    try
    {
      Object localObject1 = null;
      Object localObject2;
      Object localObject3;
      if ((paramFile.getName().toLowerCase().trim().endsWith(".rpk")) || (paramFile.getName().toLowerCase().indexOf(".rpk") > 0))
      {
        localObject2 = (RulePackage)new com.flagleader.repository.e.d().load(paramFile);
        if (!m.a().a(((RulePackage)localObject2).getExeRulePackageName()))
        {
          this.b.showError(com.flagleader.manager.d.c.b("noright.importpackage"));
          return;
        }
        if (m.a().e() == 1)
          ((RulePackage)localObject2).setEdittype(RulePackage.EDITER);
        ((RulePackage)localObject2).setFilePathName(paramFile.getAbsolutePath());
        if ((d() != null) && ((d() instanceof RuleRepository)))
        {
          localObject3 = ((RuleRepository)d()).exitsPackage(((RulePackage)localObject2).getExeRulePackageName());
          if (localObject3 != null)
          {
            this.b.showError(com.flagleader.manager.d.c.b("exitsPackError.importpackage"));
            return;
          }
          ((RuleRepository)d()).addRulePackage((RulePackage)localObject2);
        }
        else
        {
          localObject3 = new RuleRepository();
          ((RuleRepository)localObject3).addRulePackage((RulePackage)localObject2);
          a((IRuleRepository)localObject3);
          com.flagleader.manager.d.b.a().a((RuleRepository)localObject3);
        }
        if (!paramFile.canWrite())
          ((RulePackage)localObject2).setLocked(true);
        localObject1 = localObject2;
      }
      else if (paramFile.getName().toLowerCase().trim().endsWith(".prj"))
      {
        localObject2 = (ProjectInfo)new com.flagleader.repository.e.f().load(paramFile);
        if ((d() != null) && ((d() instanceof RuleRepository)))
        {
          localObject3 = ((RuleRepository)d()).exitsProject(((ProjectInfo)localObject2).getUuid());
          if ((localObject3 != null) && (((RuleProject)localObject3).isOpened()))
          {
            this.b.showError(com.flagleader.manager.d.c.b("same_project"));
            return;
          }
          if (localObject3 != null)
            ((RuleProject)localObject3).dispose();
        }
        localObject3 = new RuleProject();
        ((RuleProject)localObject3).setFilePath(paramFile.getPath());
        if ((d() != null) && ((d() instanceof RuleRepository)))
        {
          ((RuleRepository)d()).addRuleProject((IRuleProject)localObject3);
        }
        else
        {
          RuleRepository localRuleRepository = new RuleRepository();
          if (new File(RuleRepository.DEFAULTEXT).exists())
          {
            localRuleRepository = (RuleRepository)new v().load(new File(RuleRepository.DEFAULTEXT));
            localRuleRepository.clearAllChildren();
          }
          localRuleRepository.setRepFile(new File(RuleRepository.DEFAULTEXT));
          com.flagleader.manager.d.b.a().a(localRuleRepository);
          localRuleRepository.addRuleProject((IRuleProject)localObject3);
          a(localRuleRepository);
        }
        ((RuleProject)localObject3).open();
        localObject1 = localObject3;
      }
      else
      {
        localObject2 = (RuleRepository)new v().load(paramFile);
        if (localObject2 != null)
        {
          ((RuleRepository)localObject2).setRepFile(paramFile.getAbsoluteFile());
          ((RuleRepository)localObject2).open();
          localObject1 = localObject2;
          com.flagleader.manager.d.b.a().a((RuleRepository)localObject2);
          a((IRuleRepository)localObject2);
        }
      }
      if ((localObject1 != null) && (localObject1.getAutoSavedPack().size() > 0))
        this.b.showDialog(new com.flagleader.manager.dialog.d.c(localObject1));
      j().c(com.flagleader.manager.d.c.a("HasBeenLoad", new String[] { paramFile.getPath() }));
    }
    catch (Exception localException)
    {
      j().a(localException.getMessage(), localException);
    }
  }

  public void a(IRuleRepository paramIRuleRepository)
  {
    if (this.j != null)
    {
      if ((this.j instanceof RuleRepository))
        ((RuleRepository)this.j).setForceClose(true);
      this.j.disposeAndUpdate();
    }
    this.j = paramIRuleRepository;
    if (this.j != null)
    {
      this.j.setRuleServer(this);
      this.m.a(paramIRuleRepository);
      this.b.getProjectTree().i();
      k = this.j;
    }
  }

  public com.flagleader.manager.a.a.g e()
  {
    return new com.flagleader.manager.a.a.g(this);
  }

  public void a(String paramString1, String paramString2)
  {
    try
    {
      com.flagleader.manager.a.a.g localg = e();
      if (localg.a(Integer.parseInt(paramString1), paramString2, ""))
        b(localg.d(), localg.a(), localg.h());
    }
    catch (Exception localException)
    {
      this.b.showError(localException.getMessage());
    }
  }

  public void a(RulePackage paramRulePackage, String paramString)
  {
    if (b().isWebEditor())
      u().a(paramRulePackage, true, 0, paramString, false);
  }

  public void a(String paramString)
  {
    Object localObject;
    if (d() != null)
    {
      localObject = d().getDBProject(paramString);
      if (localObject != null)
      {
        b().showError(com.flagleader.manager.d.c.b("exitsPackError.importpackage"));
      }
      else
      {
        d().addDBProject(paramString);
        d().updateTree();
      }
    }
    else
    {
      localObject = new RuleRepository();
      ((RuleRepository)localObject).addDBProject(paramString);
      a((IRuleRepository)localObject);
      com.flagleader.manager.d.b.a().a((RuleRepository)localObject);
      d().updateTree();
    }
  }

  public void a(IRulePackage paramIRulePackage, String paramString1, String paramString2)
  {
    Object localObject;
    if (d() != null)
    {
      localObject = d().exitsPackage(paramIRulePackage.getExeRulePackageName());
      if (localObject != null)
      {
        b().showError(com.flagleader.manager.d.c.b("exitsPackError.importpackage"));
      }
      else
      {
        d().addProjPackage(paramIRulePackage, paramString1, paramString2);
        d().updateTree();
      }
    }
    else
    {
      localObject = new RuleRepository();
      ((RuleRepository)localObject).addProjPackage(paramIRulePackage, paramString1, paramString2);
      a((IRuleRepository)localObject);
      com.flagleader.manager.d.b.a().a((RuleRepository)localObject);
      d().updateTree();
    }
  }

  public void b(IRulePackage paramIRulePackage, String paramString1, String paramString2)
  {
    Object localObject;
    if (d() != null)
    {
      localObject = d().exitsDBPackage(paramIRulePackage.getExeRulePackageName());
      if (localObject != null)
      {
        b().showError(com.flagleader.manager.d.c.b("exitsPackError.importpackage"));
      }
      else
      {
        d().addDBPackage(paramIRulePackage, paramString1, paramString2);
        d().updateTree();
      }
    }
    else
    {
      localObject = new RuleRepository();
      ((RuleRepository)localObject).addDBPackage(paramIRulePackage, paramString1, paramString2);
      a((IRuleRepository)localObject);
      com.flagleader.manager.d.b.a().a((RuleRepository)localObject);
      d().updateTree();
    }
  }

  public void a(InputStream paramInputStream)
  {
    IRulePackage localIRulePackage = (IRulePackage)new com.flagleader.repository.e.d().load(paramInputStream);
    if (d() != null)
    {
      d().addChildElement(localIRulePackage);
    }
    else
    {
      RuleRepository localRuleRepository = new RuleRepository();
      localRuleRepository.addChildElement(localIRulePackage);
      a(localRuleRepository);
      com.flagleader.manager.d.b.a().a(localRuleRepository);
    }
  }

  public IRulePackage f()
  {
    if (d() == null)
      return null;
    Iterator localIterator = d().getChildrenIterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRulePackage))
        return (IRulePackage)localObject;
    }
    return null;
  }

  public void g()
  {
    try
    {
      if (d() != null)
        d().autoSave();
    }
    catch (Exception localException)
    {
      j().b(localException.getMessage(), localException);
    }
  }

  public void h()
  {
    if ((z() > 0) && (d() != null))
      try
      {
        com.flagleader.manager.a.a.c localc = p();
        List localList1 = localc.a(0);
        Iterator localIterator = d().getAcceptElements(new s(this));
        StringBuffer localStringBuffer = new StringBuffer();
        Object localObject;
        int i1;
        while (localIterator.hasNext())
        {
          localObject = (RulePackage)localIterator.next();
          for (i1 = 0; (localList1 != null) && (i1 < localList1.size()); i1++)
          {
            List localList2 = (List)localList1.get(i1);
            if (!localList2.get(2).toString().equalsIgnoreCase(((RulePackage)localObject).getExeRulePackageName()))
              continue;
            if (((RulePackage)localObject).getServerTime() + 1000L <= ((Date)localList2.get(5)).getTime())
              localStringBuffer.append(((RulePackage)localObject).toString()).append(" : ").append(StringUtil.stringValue(localList2.get(4))).append("\t").append(localList2.get(8)).append("\t").append(StringUtil.stringValue(localList2.get(5))).append("\t").append(StringUtil.stringValue(localList2.get(7))).append(StringUtil.newline);
            ((RulePackage)localObject).setServerTime(((Date)localList2.get(5)).getTime());
          }
        }
        if (localStringBuffer.length() > 0)
        {
          b().showInformation(com.flagleader.manager.d.c.b("ruleupdatedserver.info"), localStringBuffer.toString());
          j().c(com.flagleader.manager.d.c.b("ruleupdatedserver.info"));
          localObject = localStringBuffer.toString().split(StringUtil.newline);
          for (i1 = 0; i1 < localObject.length; i1++)
            j().c(localObject[i1]);
        }
      }
      catch (Exception localException)
      {
      }
  }

  public void i()
  {
    if (d() != null)
      c().h(d());
  }

  public com.flagleader.repository.h j()
  {
    if (d() != null)
      return d().getLogger();
    return k();
  }

  public com.flagleader.repository.h k()
  {
    return m.a().j();
  }

  public t l()
  {
    return this.l;
  }

  public com.flagleader.manager.c.b a(com.flagleader.manager.c.c paramc, ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof CustomSql))
      return new com.flagleader.manager.c.a.f(paramc, (CustomSql)paramITreeNode, this);
    if ((paramITreeNode instanceof DBModel))
      return new com.flagleader.manager.c.a.j(paramc, (DBModel)paramITreeNode, this);
    if ((paramITreeNode instanceof BOContainerGroup))
      return new com.flagleader.manager.c.a.a(paramc, (BOContainerGroup)paramITreeNode, this);
    if ((paramITreeNode instanceof EnumTable))
      return new com.flagleader.manager.c.a.u(paramc, (EnumTable)paramITreeNode, this);
    if ((paramITreeNode instanceof CustomFunction))
      return new ac(paramc, (CustomFunction)paramITreeNode, this);
    if ((paramITreeNode instanceof ProcedureModel))
      return new ag(paramc, (ProcedureModel)paramITreeNode, this);
    if ((paramITreeNode instanceof SelectTable))
      return new al(paramc, (SelectTable)paramITreeNode, this);
    if ((paramITreeNode instanceof SheetTable))
      return new aw(paramc, (SheetTable)paramITreeNode, this);
    if ((paramITreeNode instanceof SheetMap))
      return new ar(paramc, (SheetMap)paramITreeNode, this);
    if ((paramITreeNode instanceof TableModel))
      return new aX(paramc, (TableModel)paramITreeNode, this);
    if ((paramITreeNode instanceof ViewModel))
      return new bi(paramc, (ViewModel)paramITreeNode, this);
    if ((paramITreeNode instanceof XmlNode))
      return new bj(paramc, (XmlNode)paramITreeNode, this);
    if ((paramITreeNode instanceof TreeValueNode))
      return new bc(paramc, (TreeValueNode)paramITreeNode, this);
    if ((paramITreeNode instanceof ClassContainer))
      return new com.flagleader.manager.c.a.b(paramc, (ClassContainer)paramITreeNode, this);
    if ((paramITreeNode instanceof InterfaceContainer))
      return new ad(paramc, (InterfaceContainer)paramITreeNode, this);
    if ((paramITreeNode instanceof SoapService))
      return new aL(paramc, (SoapService)paramITreeNode, this);
    if ((paramITreeNode instanceof DecisionMultiRule))
      return new com.flagleader.manager.c.d.g(paramc, (DecisionMultiRule)paramITreeNode, this);
    if ((paramITreeNode instanceof ExpressionRule))
      return new com.flagleader.manager.c.d.r(paramc, (ExpressionRule)paramITreeNode, this);
    if ((paramITreeNode instanceof DecisionRelateRule))
      return new k(paramc, (DecisionRelateRule)paramITreeNode, this);
    if ((paramITreeNode instanceof DecisionRule))
      return new o(paramc, (DecisionRule)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleMirror))
      return new x(paramc, (RuleMirror)paramITreeNode, this);
    if ((paramITreeNode instanceof RulePackage))
      return new y(paramc, (RulePackage)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleProject))
      return new W(paramc, (RuleProject)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleDBProject))
      return new com.flagleader.manager.c.d.u(paramc, (RuleDBProject)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleGroup))
      return new w(paramc, (RuleGroup)paramITreeNode, this);
    if ((paramITreeNode instanceof Rule))
      return new Z(paramc, (Rule)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleSetFlow))
      return new aj(paramc, (RuleSetFlow)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleTreeFlow))
      return new com.flagleader.manager.c.d.an(paramc, (RuleTreeFlow)paramITreeNode, this);
    if ((paramITreeNode instanceof RulePoolFlow))
      return new V(paramc, (RulePoolFlow)paramITreeNode, this);
    if ((paramITreeNode instanceof RuleSet))
      return new ak(paramc, (RuleSet)paramITreeNode, this);
    if ((paramITreeNode instanceof ExportModel))
      return new p(paramc, (ExportModel)paramITreeNode, this);
    if ((paramITreeNode instanceof AjaxPage))
      return new com.flagleader.manager.c.b.a(paramc, (AjaxPage)paramITreeNode, this);
    if ((paramITreeNode instanceof ExcelBookModel))
      return new z(paramc, (ExcelBookModel)paramITreeNode, this);
    if ((paramITreeNode instanceof ExcelTableSheetModel))
      return new J(paramc, (ExcelTableSheetModel)paramITreeNode, this);
    if ((paramITreeNode instanceof ExcelXYSheetModel))
      return new Q(paramc, (ExcelXYSheetModel)paramITreeNode, this);
    if ((paramITreeNode instanceof ExcelSheetModel))
      return new D(paramc, (ExcelSheetModel)paramITreeNode, this);
    if ((paramITreeNode instanceof TestCaseLib))
      return new aC(paramc, (TestCaseLib)paramITreeNode, this);
    if ((paramITreeNode instanceof TestCase))
      return new aE(paramc, (TestCase)paramITreeNode, this);
    return null;
  }

  public n m()
  {
    return this.m;
  }

  public RuleService n()
  {
    return this.n.getRuleService();
  }

  public com.flagleader.manager.a.a.d o()
  {
    return new com.flagleader.manager.a.a.d(this);
  }

  public com.flagleader.manager.a.a.c p()
  {
    return new com.flagleader.manager.a.a.c(this);
  }

  public e q()
  {
    return new e(this);
  }

  public com.flagleader.manager.a.a.j r()
  {
    return new com.flagleader.manager.a.a.j(this);
  }

  public com.flagleader.manager.a.a.h s()
  {
    return new com.flagleader.manager.a.a.h(this);
  }

  public com.flagleader.manager.a.a.f t()
  {
    return new com.flagleader.manager.a.a.f(this);
  }

  public com.flagleader.manager.a.a.a u()
  {
    return new com.flagleader.manager.a.a.a(this);
  }

  public boolean v()
  {
    if (com.flagleader.manager.d.c.a())
      return (a() != null) && (this.h == 3);
    if (a() != null)
      return this.h == 3;
    return true;
  }

  public boolean w()
  {
    if (com.flagleader.manager.d.c.a())
      return (a() != null) && (this.h >= 2);
    if (a() != null)
      return this.h >= 2;
    return true;
  }

  public boolean x()
  {
    if (com.flagleader.manager.d.c.a())
      return (a() != null) && (this.h >= 1);
    if (a() != null)
      return this.h >= 1;
    return true;
  }

  public int y()
  {
    if (com.flagleader.manager.d.c.a())
      return this.h;
    if (a() != null)
      return this.h;
    return 3;
  }

  public int z()
  {
    return this.g;
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public static IRuleRepository A()
  {
    return k;
  }

  public boolean B()
  {
    return this.i;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.r
 * JD-Core Version:    0.6.0
 */