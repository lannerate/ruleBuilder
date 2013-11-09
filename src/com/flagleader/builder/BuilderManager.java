package com.flagleader.builder;

import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.ActionsManager;
import com.flagleader.builder.actions.aO;
import com.flagleader.builder.actions.ak;
import com.flagleader.builder.actions.al;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.actions.b.y;
import com.flagleader.builder.actions.bf;
import com.flagleader.builder.actions.bm;
import com.flagleader.builder.actions.g.A;
import com.flagleader.builder.dialogs.AboutLicenseDialog;
import com.flagleader.database.ConnectionFactory;
import com.flagleader.database.ConnectionInfo;
import com.flagleader.db.DBFactory;
import com.flagleader.db.Database;
import com.flagleader.manager.builder.IAfterAction;
import com.flagleader.manager.dialog.IDialogInfo;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BuilderManager
  implements com.flagleader.manager.builder.b
{
  private IApplication d;
  private aO e;
  private bu f;
  private bf g;
  private ActionsManager h;
  private al i;
  private aq j;
  private bm k;
  private boolean l = false;
  public static final String VERSION = "RuleBuilder3.0.0";
  com.flagleader.manager.r a = null;
  private HashMap m = new HashMap();

  public BuilderManager(IApplication paramIApplication)
  {
    this.d = paramIApplication;
    if (isPlugInApp())
      com.flagleader.manager.d.c.a("plug");
    this.a = new com.flagleader.manager.r(this);
    this.i = new al(this);
    this.k = new bm(this);
    this.f = new bu(this);
    this.j = new aq(this);
    this.e = new aO(this);
    this.g = new bf(this);
    this.h = new ActionsManager(this);
    a();
  }

  public Composite createContent(Composite paramComposite)
  {
    return this.k.a(paramComposite);
  }

  public com.flagleader.manager.builder.d getProjectTree()
  {
    return this.e;
  }

  public ActionsManager getActionsManager()
  {
    return this.h;
  }

  public bf getListenersManager()
  {
    return this.g;
  }

  public aq getMessageWindow()
  {
    return this.j;
  }

  public bu getRuleEditor()
  {
    return this.f;
  }

  public al getMenuAndToolBar()
  {
    return this.i;
  }

  public Shell getShell()
  {
    return this.d.getShell();
  }

  public boolean isPlugInApp()
  {
    return this.d.canLoadClass();
  }

  public String loadNewClass(String paramString)
  {
    return this.d.loadNewClass(paramString);
  }

  public void updateEditor()
  {
    if (this.d != null)
      this.d.updateEditor();
  }

  public void loadByPluginStream(InputStream paramInputStream)
  {
    getRulesManager().a(paramInputStream);
  }

  public boolean setDemoKey(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll");
    if (localFile.exists())
      com.flagleader.a.a.r.a(paramString2, localFile, paramString3, "RulePlugin3.0.0");
    if ((!com.flagleader.a.a.r.g()) && (!com.flagleader.a.a.r.h()))
    {
      com.flagleader.a.a.r.b(paramString1, "RulePlugin3.0.0");
      com.flagleader.manager.d.c.a("free");
    }
    else
    {
      com.flagleader.manager.d.c.a("plug");
    }
    return true;
  }

  public static String getCheckKey()
  {
    Init.a();
    return com.flagleader.a.a.r.a(new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll"));
  }

  public static boolean checkLicense()
  {
    File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll");
    if (com.flagleader.a.a.r.c(BuilderConfig.getInstance().getUserName(), BuilderConfig.getInstance().getLicenseKey()))
    {
      if (BuilderConfig.getInstance().getUserName().equals("杭州华三通信技术有限公司"))
        com.flagleader.manager.d.c.a("h3c");
      else
        com.flagleader.manager.d.c.a("prof");
    }
    else if ((localFile.exists()) && (com.flagleader.a.a.r.a(BuilderConfig.getInstance().getUserName(), localFile, BuilderConfig.getInstance().getLicenseKey(), "RuleBuilder3.0.0")))
    {
      com.flagleader.manager.d.c.a("prof");
    }
    else
    {
      Object localObject;
      if (com.flagleader.a.a.r.b(BuilderConfig.getInstance().getDemoKey(), "RuleBuilder4.0.0"))
      {
        if ((com.flagleader.a.a.r.f()) && (com.flagleader.a.a.r.d() > 30L))
        {
          com.flagleader.manager.d.c.a("stan");
          return true;
        }
        if (com.flagleader.a.a.r.e())
        {
          localObject = new InputDialog(new Shell(), ResourceTools.getMessage("error.dialog"), ResourceTools.getMessage("licenseExpired"), BuilderConfig.getInstance().getDemoKey(), null);
          if (((InputDialog)localObject).open() == 0)
          {
            com.flagleader.a.a.r.b(((InputDialog)localObject).getValue(), "RuleBuilder4.0.0");
            BuilderConfig.getInstance().setDemoKey(((InputDialog)localObject).getValue());
            BuilderConfig.getInstance().save();
          }
        }
        if (com.flagleader.a.a.r.e())
        {
          MessageDialog.openError(new Shell(), ResourceTools.getMessage("error.dialog"), ResourceTools.getMessage("licenseExpired"));
          com.flagleader.manager.d.c.a("test");
          localObject = new com.flagleader.builder.dialogs.t();
          if (((com.flagleader.builder.dialogs.t)localObject).open() != 0)
            return false;
        }
        else
        {
          com.flagleader.manager.d.c.a("stan");
          localObject = new AboutLicenseDialog(null);
          if (((AboutLicenseDialog)localObject).open() != 0)
            return false;
        }
      }
      else
      {
        com.flagleader.a.a.r.b(BuilderConfig.getInstance().getDemoKey(), "RuleBuilder3.0.0");
        if (com.flagleader.a.a.r.e())
        {
          localObject = new InputDialog(new Shell(), ResourceTools.getMessage("error.dialog"), ResourceTools.getMessage("licenseExpired"), BuilderConfig.getInstance().getDemoKey(), null);
          if (((InputDialog)localObject).open() == 0)
          {
            com.flagleader.a.a.r.b(((InputDialog)localObject).getValue(), "RuleBuilder3.0.0");
            BuilderConfig.getInstance().setDemoKey(((InputDialog)localObject).getValue());
            BuilderConfig.getInstance().save();
          }
        }
        if (com.flagleader.a.a.r.e())
        {
          MessageDialog.openError(new Shell(), ResourceTools.getMessage("error.dialog"), ResourceTools.getMessage("licenseExpired"));
          com.flagleader.manager.d.c.a("test");
          localObject = new com.flagleader.builder.dialogs.t();
          if (((com.flagleader.builder.dialogs.t)localObject).open() != 0)
            return false;
        }
        else
        {
          com.flagleader.manager.d.c.a("trail");
          localObject = new AboutLicenseDialog(null);
          if (((AboutLicenseDialog)localObject).open() != 0)
            return false;
        }
      }
    }
    return true;
  }

  public void dispose()
  {
    com.flagleader.repository.db.a.b.b();
    if (this.a.d() != null)
      this.a.d().dispose();
    this.f.g();
    this.k.f();
    this.g = null;
    this.h = null;
    this.i = null;
    this.f = null;
    this.j = null;
    this.e = null;
    this.k = null;
  }

  public boolean isWebEditor()
  {
    return this.l;
  }

  public void setWebEditor(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void showError(String paramString)
  {
    Display.getDefault().asyncExec(new a(this, paramString));
  }

  public void showSuccess(String paramString)
  {
    Display.getDefault().asyncExec(new b(this, paramString));
  }

  public void showInformation(String paramString1, String paramString2)
  {
    Display.getDefault().asyncExec(new c(this, paramString1, paramString2));
  }

  public void showWarning(String paramString)
  {
    MessageDialog.openWarning(getShell(), ResourceTools.getMessage("warning.dialog"), paramString);
  }

  public boolean showConfirm(String paramString)
  {
    return MessageDialog.openConfirm(getShell(), ResourceTools.getMessage("confirm.dialog"), paramString);
  }

  public boolean showQuestion(String paramString)
  {
    return MessageDialog.openQuestion(getShell(), ResourceTools.getMessage("question.dialog"), paramString);
  }

  public void showConfirm(String paramString, IAfterAction paramIAfterAction)
  {
    if (MessageDialog.openConfirm(getShell(), ResourceTools.getMessage("confirm.dialog"), paramString))
      paramIAfterAction.ok();
    else
      paramIAfterAction.cancel();
  }

  public void showQuestion(String paramString, IAfterAction paramIAfterAction)
  {
    if (MessageDialog.openQuestion(getShell(), ResourceTools.getMessage("question.dialog"), paramString))
      paramIAfterAction.ok();
    else
      paramIAfterAction.cancel();
  }

  public void copy(IElement paramIElement)
  {
    new Clipboard(Display.getCurrent()).setContents(new Object[] { paramIElement }, new Transfer[] { com.flagleader.builder.widget.d.a() });
    getMessageWindow().a(paramIElement);
  }

  public IElement paste()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.d.a());
    if ((localObject != null) && ((localObject instanceof IElement)))
      return (IElement)localObject;
    return null;
  }

  public Connection loginRuleServer()
  {
    Connection localConnection = getDbConn();
    if (localConnection == null)
    {
      com.flagleader.builder.dialogs.h localh = new com.flagleader.builder.dialogs.h();
      if (localh.open() == 0)
        localConnection = localh.e();
      else
        return null;
    }
    return localConnection;
  }

  public void openFromServer()
  {
    List localList;
    try
    {
      com.flagleader.manager.a.a.c localc = getRulesManager().p();
      localList = localc.a();
      if (localList == null)
      {
        MessageDialog.openError(getShell(), "", localc.i());
        return;
      }
    }
    catch (Exception localException)
    {
      return;
    }
    if (localList != null)
    {
      Object localObject;
      for (int n = localList.size() - 1; n >= 0; n--)
      {
        if (getRulesManager().d() == null)
        {
          localObject = new RuleRepository();
          getRulesManager().a((IRuleRepository)localObject);
          com.flagleader.manager.d.b.a().a((RuleRepository)localObject);
        }
        if (getRulesManager().d().exitsDBPackage(((List)localList.get(n)).get(2).toString()) == null)
          continue;
        localList.remove(n);
      }
      com.flagleader.builder.dialogs.g.f localf = new com.flagleader.builder.dialogs.g.f(null, localList);
      if (localf.open() == 0)
      {
        localObject = localf.c();
        for (int i1 = 0; i1 < ((List)localObject).size(); i1++)
        {
          if ((!(((List)localObject).get(i1) instanceof List)) || (((List)((List)localObject).get(i1)).size() <= 0))
            continue;
          try
          {
            com.flagleader.manager.a.a.g localg = getRulesManager().e();
            if (!localg.a(Integer.parseInt(((List)((List)localObject).get(i1)).get(0).toString()), ((List)((List)localObject).get(i1)).get(8).toString(), ((List)((List)localObject).get(i1)).get(2).toString()))
              continue;
            RulePackage localRulePackage = localg.d();
            getRulesManager().b(localRulePackage, localg.a(), localg.h());
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            showError(localThrowable.getMessage());
          }
        }
        if (((List)localObject).size() > 0)
          getProjectTree().i();
      }
    }
  }

  public List getAllPackages()
  {
    com.flagleader.manager.a.a.c localc = getRulesManager().p();
    List localList = localc.a(0);
    if (localList == null)
    {
      MessageDialog.openError(getShell(), "", localc.i());
      return Collections.EMPTY_LIST;
    }
    return localList;
  }

  public Connection getDbConn()
  {
    try
    {
      if (getClass().getClassLoader().getResource("rules.conf") != null)
        return DBFactory.newIntance().getDatabase("rules").getConnection();
      return ConnectionFactory.getConn(new ConnectionInfo(getConfigManager().k(), getConfigManager().o(), getConfigManager().n(), getConfigManager().m(), "", ""));
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public IApplication getMainApp()
  {
    return this.d;
  }

  public com.flagleader.manager.d.b getConfigManager()
  {
    return com.flagleader.manager.d.b.a(this.a.d());
  }

  public String getUserServer()
  {
    if ((this.a.a() == null) || (this.a.a().length() == 0))
    {
      com.flagleader.builder.dialogs.o localo = new com.flagleader.builder.dialogs.o(this);
      if (localo.open() == 0)
      {
        getRulesManager().a(localo.a(), localo.c(), localo.d());
        getConfigManager().r(localo.b());
        getConfigManager().s(localo.a());
        if (isMainApplication())
          getConfigManager().b();
      }
      else
      {
        getRulesManager().a(null, 0, 0);
      }
    }
    return this.a.a();
  }

  public void showLogin(String paramString)
  {
    if (getShell() != null)
      if ((paramString != null) && (paramString.length() > 0))
        getShell().setText(ResourceTools.getMessage("RuleBuilder") + " " + paramString);
      else
        getShell().setText(ResourceTools.getMessage("RuleBuilder"));
  }

  public boolean isMainApplication()
  {
    return this.d instanceof FlagLeader;
  }

  public com.flagleader.manager.r getRulesManager()
  {
    return this.a;
  }

  public void gotoTreeNode(ITreeNode paramITreeNode)
  {
    IElementViewer localIElementViewer;
    if ((paramITreeNode instanceof IRuleSet))
    {
      getRuleEditor().a((IRuleSet)paramITreeNode);
      getRuleEditor().a(paramITreeNode);
      localIElementViewer = getRuleEditor().e();
      if (localIElementViewer != null)
        localIElementViewer.update();
    }
    else if ((paramITreeNode instanceof IPage))
    {
      getRuleEditor().a((IPage)paramITreeNode);
      getRuleEditor().a(paramITreeNode);
      localIElementViewer = getRuleEditor().e();
      if (localIElementViewer != null)
        localIElementViewer.update();
    }
    else
    {
      getProjectTree().c(paramITreeNode);
    }
  }

  public void showDialog(IDialogInfo paramIDialogInfo)
  {
    if ((paramIDialogInfo instanceof com.flagleader.manager.dialog.d.c))
      new com.flagleader.builder.dialogs.e.z(getShell(), (com.flagleader.manager.dialog.d.c)paramIDialogInfo).open();
  }

  public com.flagleader.repository.h getUserLogger()
  {
    if (getRulesManager() != null)
      return getRulesManager().j();
    return getSystemLogger();
  }

  public com.flagleader.repository.h getSystemLogger()
  {
    return com.flagleader.repository.m.a().j();
  }

  private void a(ak paramak)
  {
    this.m.put(paramak.a(), paramak);
  }

  private void a()
  {
    a(new com.flagleader.builder.actions.a.c(this));
    a(new com.flagleader.builder.actions.a.d(this));
    a(new com.flagleader.builder.actions.a.e(this));
    a(new com.flagleader.builder.actions.a.f(this));
    a(new com.flagleader.builder.actions.a.i(this));
    a(new com.flagleader.builder.actions.a.g(this));
    a(new com.flagleader.builder.actions.a.h(this));
    a(new com.flagleader.builder.actions.a.a(this));
    a(new com.flagleader.builder.actions.a.b(this));
    a(new com.flagleader.builder.actions.a.j(this));
    a(new com.flagleader.builder.actions.a.l(this));
    a(new com.flagleader.builder.actions.a.m(this));
    a(new com.flagleader.builder.actions.a.o(this));
    a(new com.flagleader.builder.actions.a.p(this));
    a(new com.flagleader.builder.actions.a.q(this));
    a(new com.flagleader.builder.actions.a.n(this));
    a(new com.flagleader.builder.actions.a.s(this));
    a(new com.flagleader.builder.actions.a.t(this));
    a(new com.flagleader.builder.actions.a.w(this));
    a(new com.flagleader.builder.actions.a.v(this));
    a(new com.flagleader.builder.actions.b.a(this));
    a(new com.flagleader.builder.actions.b.b(this));
    a(new com.flagleader.builder.actions.b.e(this));
    a(new com.flagleader.builder.actions.b.f(this));
    a(new com.flagleader.builder.actions.b.c(this));
    a(new com.flagleader.builder.actions.b.d(this));
    a(new com.flagleader.builder.actions.b.h(this));
    a(new com.flagleader.builder.actions.b.g(this));
    a(new com.flagleader.builder.actions.b.p(this));
    a(new com.flagleader.builder.actions.d.q(this));
    a(new com.flagleader.builder.actions.d.n(this));
    a(new com.flagleader.builder.actions.b.o(this));
    a(new com.flagleader.builder.actions.d.o(this));
    a(new com.flagleader.builder.actions.b.k(this));
    a(new com.flagleader.builder.actions.h.j(this));
    a(new y(this));
    a(new com.flagleader.builder.actions.b.x(this));
    a(new com.flagleader.builder.actions.h.r(this));
    a(new com.flagleader.builder.actions.b.l(this));
    a(new com.flagleader.builder.actions.b.m(this));
    a(new com.flagleader.builder.actions.b.n(this));
    a(new com.flagleader.builder.actions.e.c(this));
    a(new com.flagleader.builder.actions.e.b(this));
    a(new com.flagleader.builder.actions.b.j(this));
    a(new com.flagleader.builder.actions.b.q(this));
    a(new com.flagleader.builder.actions.b.r(this));
    a(new com.flagleader.builder.actions.b.s(this));
    a(new com.flagleader.builder.actions.b.t(this));
    a(new com.flagleader.builder.actions.b.u(this));
    a(new com.flagleader.builder.actions.b.v(this));
    a(new com.flagleader.builder.actions.b.w(this));
    a(new com.flagleader.builder.actions.b.z(this));
    a(new com.flagleader.builder.actions.c.a(this));
    a(new com.flagleader.builder.actions.c.t(this));
    a(new com.flagleader.builder.actions.c.q(this));
    a(new com.flagleader.builder.actions.c.b(this));
    a(new com.flagleader.builder.actions.c.d(this));
    a(new com.flagleader.builder.actions.c.f(this));
    a(new com.flagleader.builder.actions.c.e(this));
    a(new com.flagleader.builder.actions.c.i(this));
    a(new com.flagleader.builder.actions.c.n(this));
    a(new com.flagleader.builder.actions.c.o(this));
    a(new com.flagleader.builder.actions.c.g(this));
    a(new com.flagleader.builder.actions.c.h(this));
    a(new com.flagleader.builder.actions.c.m(this));
    a(new com.flagleader.builder.actions.c.l(this));
    a(new com.flagleader.builder.actions.c.c(this));
    a(new com.flagleader.builder.actions.c.p(this));
    a(new com.flagleader.builder.actions.c.s(this));
    a(new com.flagleader.builder.actions.d.a(this));
    a(new com.flagleader.builder.actions.d.b(this));
    a(new com.flagleader.builder.actions.d.d(this));
    a(new com.flagleader.builder.actions.d.j(this));
    a(new com.flagleader.builder.actions.d.r(this));
    a(new com.flagleader.builder.actions.d.c(this));
    a(new com.flagleader.builder.actions.d.e(this));
    a(new com.flagleader.builder.actions.d.f(this));
    a(new com.flagleader.builder.actions.d.h(this));
    a(new com.flagleader.builder.actions.d.i(this));
    a(new com.flagleader.builder.actions.d.k(this));
    a(new com.flagleader.builder.actions.d.p(this));
    a(new com.flagleader.builder.actions.f.a(this));
    a(new com.flagleader.builder.actions.f.c(this));
    a(new com.flagleader.builder.actions.f.e(this));
    a(new com.flagleader.builder.actions.f.f(this));
    a(new com.flagleader.builder.actions.f.g(this));
    a(new com.flagleader.builder.actions.f.h(this));
    a(new com.flagleader.builder.actions.g.g(this));
    a(new com.flagleader.builder.actions.g.i(this));
    a(new com.flagleader.builder.actions.g.j(this));
    a(new com.flagleader.builder.actions.g.m(this));
    a(new com.flagleader.builder.actions.g.n(this));
    a(new com.flagleader.builder.actions.g.d(this));
    a(new A(this));
    a(new com.flagleader.builder.actions.g.u(this));
    a(new com.flagleader.builder.actions.g.v(this));
    a(new com.flagleader.builder.actions.h.a(this));
    a(new com.flagleader.builder.actions.h.c(this));
    a(new com.flagleader.builder.actions.h.b(this));
    a(new com.flagleader.builder.actions.h.d(this));
    a(new com.flagleader.builder.actions.h.f(this));
    a(new com.flagleader.builder.actions.h.g(this));
    a(new com.flagleader.builder.actions.h.i(this));
    a(new com.flagleader.builder.actions.h.h(this));
    a(new com.flagleader.builder.actions.h.e(this));
    a(new com.flagleader.builder.actions.h.k(this));
    a(new com.flagleader.builder.actions.h.m(this));
    a(new com.flagleader.builder.actions.g.o(this));
    a(new com.flagleader.builder.actions.g.p(this));
    a(new com.flagleader.builder.actions.g.w(this));
    a(new com.flagleader.builder.actions.i.a(this));
    a(new com.flagleader.builder.actions.i.j(this));
    a(new com.flagleader.builder.actions.i.h(this));
    a(new com.flagleader.builder.actions.i.f(this));
    a(new com.flagleader.builder.actions.i.b(this));
    a(new com.flagleader.builder.actions.i.c(this));
    a(new com.flagleader.builder.actions.i.d(this));
    a(new com.flagleader.builder.actions.i.e(this));
    a(new com.flagleader.builder.actions.i.l(this));
    a(new com.flagleader.builder.actions.i.m(this));
    a(new com.flagleader.builder.actions.i.n(this));
    a(new com.flagleader.builder.actions.i.o(this));
    a(new com.flagleader.builder.actions.i.p(this));
    a(new com.flagleader.builder.actions.i.q(this));
    a(new com.flagleader.builder.actions.i.s(this));
    a(new com.flagleader.builder.actions.i.u(this));
    a(new com.flagleader.builder.actions.j.a(this));
    a(new com.flagleader.builder.actions.j.v(this));
    a(new com.flagleader.builder.actions.j.b(this));
    a(new com.flagleader.builder.actions.j.c(this));
    a(new com.flagleader.builder.actions.j.d(this));
    a(new com.flagleader.builder.actions.j.e(this));
    a(new com.flagleader.builder.actions.j.f(this));
    a(new com.flagleader.builder.actions.j.j(this));
    a(new com.flagleader.builder.actions.j.g(this));
    a(new com.flagleader.builder.actions.j.p(this));
    a(new com.flagleader.builder.actions.j.i(this));
    a(new com.flagleader.builder.actions.j.h(this));
    a(new com.flagleader.builder.actions.j.q(this));
    a(new com.flagleader.builder.actions.j.a.a(this));
    a(new com.flagleader.builder.actions.j.a.b(this));
    a(new com.flagleader.builder.actions.j.a.c(this));
    a(new com.flagleader.builder.actions.j.r(this));
    a(new com.flagleader.builder.actions.j.w(this));
    a(new com.flagleader.builder.actions.j.a.d(this));
    a(new com.flagleader.builder.actions.a.k(this));
    a(new com.flagleader.builder.actions.j.m(this));
    a(new com.flagleader.builder.actions.j.k(this));
    a(new com.flagleader.builder.actions.j.l(this));
    a(new com.flagleader.builder.actions.j.s(this));
    a(new com.flagleader.builder.actions.j.t(this));
    a(new com.flagleader.builder.actions.j.u(this));
    a(new com.flagleader.builder.actions.d.s(this));
    a(new com.flagleader.builder.actions.e.d(this));
    a(new com.flagleader.builder.actions.e.e(this));
    a(new com.flagleader.builder.actions.e.f(this));
    a(new com.flagleader.builder.actions.c.j(this));
    a(new com.flagleader.builder.actions.c.k(this));
    a(new com.flagleader.builder.actions.d.l(this));
    a(new com.flagleader.builder.actions.d.m(this));
    a(new com.flagleader.builder.actions.h.p(this));
    a(new com.flagleader.builder.actions.j.n(this));
    a(new com.flagleader.builder.actions.j.o(this));
    a(new com.flagleader.builder.actions.g.x(this));
    a(new com.flagleader.builder.actions.g.s(this));
    a(new com.flagleader.builder.actions.g.t(this));
    a(new com.flagleader.builder.actions.g.r(this));
    a(new com.flagleader.builder.actions.g.c(this));
    a(new com.flagleader.builder.actions.g.h(this));
    a(new com.flagleader.builder.actions.g.b(this));
    a(new com.flagleader.builder.actions.h.q(this));
    a(new com.flagleader.builder.actions.h.n(this));
  }

  public ak getTreeNodeAction(String paramString)
  {
    if (this.m.get(paramString) != null)
      return (ak)this.m.get(paramString);
    return null;
  }

  public bm getWindowsManager()
  {
    return this.k;
  }

  public int getUserid()
  {
    return this.a.z();
  }

  public int getUserType()
  {
    return this.a.y();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.BuilderManager
 * JD-Core Version:    0.6.0
 */