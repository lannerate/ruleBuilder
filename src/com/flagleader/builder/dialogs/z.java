package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.a;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.m;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.HashMap;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class z extends f
{
  private Button b;
  private Button c;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private Button k;
  private Button l;
  private Button m;
  private Button n;
  private Button o;
  private Text p;
  private Text q;
  private Text r;
  private Text s;
  private Text t;
  private Text u;
  private Text v;
  private Text w;
  private Text x;
  private static HashMap y = new HashMap();
  private Combo z;
  private Text A;
  private Text B;
  private Text C;
  private Text D;
  private Text E;
  private Text F;
  private Text G;
  private Text H;
  private Text I;
  private Text J;
  BuilderManager a;

  static
  {
    String[] arrayOfString = a.b("drivers");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      y.put(a.a(arrayOfString[i1] + ".Driver"), a.a(arrayOfString[i1] + ".URL"));
  }

  public z(BuilderManager paramBuilderManager)
  {
    super(Display.getCurrent().getActiveShell());
    c("title.SetDialog");
    this.a = paramBuilderManager;
  }

  private boolean a(String paramString)
  {
    String[] arrayOfString = c.e("setting.editor");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      if (arrayOfString[i1].equals(paramString))
        return true;
    return false;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    localComposite.setLayout(new GridLayout());
    CTabFolder localCTabFolder = new CTabFolder(localComposite, 8388736);
    localCTabFolder.setLayoutData(new GridData(1808));
    CTabItem localCTabItem;
    Group localGroup;
    if (a("save"))
    {
      localCTabItem = new CTabItem(localCTabFolder, 0);
      localCTabItem.setText(b("saveItem.SetDialog"));
      localGroup = new Group(localCTabFolder, 0);
      localGroup.setLayout(new GridLayout());
      localGroup.setLayoutData(new GridData(1808));
      d(localGroup);
      localCTabItem.setControl(localGroup);
    }
    if (a("edit"))
    {
      localCTabItem = new CTabItem(localCTabFolder, 0);
      localCTabItem.setText(b("editItem.SetDialog"));
      localGroup = new Group(localCTabFolder, 0);
      localGroup.setLayout(new GridLayout());
      localGroup.setLayoutData(new GridData(1808));
      e(localGroup);
      localCTabItem.setControl(localGroup);
    }
    if (a("server"))
    {
      localCTabItem = new CTabItem(localCTabFolder, 0);
      localCTabItem.setText(b("dbItem.SetDialog"));
      localGroup = new Group(localCTabFolder, 0);
      localGroup.setLayout(new GridLayout());
      localGroup.setLayoutData(new GridData(1808));
      g(localGroup);
      localCTabItem.setControl(localGroup);
    }
    if (a("ftp"))
    {
      localCTabItem = new CTabItem(localCTabFolder, 0);
      localCTabItem.setText(b("ftpItem.SetDialog"));
      localGroup = new Group(localCTabFolder, 0);
      localGroup.setLayout(new GridLayout());
      localGroup.setLayoutData(new GridData(1808));
      f(localGroup);
      localCTabItem.setControl(localGroup);
    }
    localCTabFolder.setSelection(0);
    return localComposite;
  }

  private void d(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    this.b = a(localComposite, "autoCompile.SetDialog", 32);
    this.b.setSelection(b.a().g());
    localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(3));
    a(localComposite, "exportExePath.SetDialog");
    this.p = b(localComposite, 2048, 150, 10);
    this.p.setEnabled(true);
    this.p.setText(b.a().f());
    Button localButton = a(localComposite, "browse", 8);
    localButton.addSelectionListener(new A(this));
    localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    this.d = a(localComposite, "autoExportPage.SetDialog", 32);
    this.d.setSelection(b.a().q());
    localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(3));
    a(localComposite, "exportPagePath.SetDialog");
    this.q = b(localComposite, 2048, 180, 10);
    this.q.setEnabled(true);
    this.q.setText(b.a().d());
    localButton = a(localComposite, "browse", 8);
    localButton.addSelectionListener(new D(this));
    localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(3));
    this.c = a(localComposite, "autoSave.SetDialog", 32);
    this.c.setSelection(BuilderConfig.getInstance().isAutosave());
    this.c.addSelectionListener(new E(this));
    this.r = b(localComposite, 2048, 80, 10);
    this.r.setText(new Long(BuilderConfig.getInstance().getAutosaveTime()).toString());
    this.r.setEnabled(this.c.getSelection());
    localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    a(localComposite, "license.SetDialog");
    this.s = b(localComposite, 2048, 250, 10);
    this.s.setEnabled(true);
    this.s.setText(BuilderConfig.getInstance().getDemoKey());
  }

  private void e(Composite paramComposite)
  {
    Composite localComposite1 = new Composite(paramComposite, 0);
    localComposite1.setLayout(a(2));
    a(localComposite1, b("dateFormat.SetDialog")).setLayoutData(b(100));
    this.t = a(localComposite1, 2048);
    this.t.setLayoutData(b(240));
    this.t.setText(b.a().h());
    a(localComposite1, b("datetimeFormat.SetDialog")).setLayoutData(b(100));
    this.v = a(localComposite1, 2048);
    this.v.setLayoutData(b(240));
    this.v.setText(b.a().i());
    a(localComposite1, b("rspRoot.SetDialog")).setLayoutData(b(100));
    this.u = a(localComposite1, 2048);
    this.u.setLayoutData(b(240));
    this.u.setText(b.a().l());
    a(localComposite1, b("jspRoot.SetDialog")).setLayoutData(b(100));
    this.w = a(localComposite1, 2048);
    this.w.setLayoutData(b(240));
    this.w.setText(b.a().p());
    a(localComposite1, "classDir.SetDialog");
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(h.a(2));
    this.x = b(localComposite2, 2048, 200, 14);
    this.x.setEnabled(true);
    this.x.setText(b.a().c());
    a(localComposite2, "browse", 8).addSelectionListener(new F(this));
    this.h = a(localComposite1, "autoCheck.SetDialog", 32);
    this.h.setSelection(b.a().E());
    this.m = a(localComposite1, "logTrace.SetDialog", 32);
    this.m.setSelection(b.a().G());
    this.m.addSelectionListener(new G(this));
    this.i = a(localComposite1, "showVarname.SetDialog", 32);
    this.i.setSelection(b.a().F());
    this.j = a(localComposite1, "stringAssign.SetDialog", 32);
    this.j.setSelection(m.a().d() == 1);
    this.j.addSelectionListener(new H(this));
    this.k = a(localComposite1, "numberAssign.SetDialog", 32);
    this.k.setSelection(m.a().c() == 1);
    this.k.addSelectionListener(new I(this));
    this.l = a(localComposite1, "dateAssign.SetDialog", 32);
    this.l.setSelection(m.a().b() == 1);
    this.l.addSelectionListener(new J(this));
  }

  private void f(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    a(localComposite, b("ftpServer.SetDialog")).setLayoutData(b(100));
    this.E = a(localComposite, 2048);
    this.E.setLayoutData(b(240));
    this.E.setText(b.a().u());
    a(localComposite, b("ftpUser.SetDialog")).setLayoutData(b(100));
    this.F = a(localComposite, 2048);
    this.F.setLayoutData(b(240));
    this.F.setText(b.a().v());
    a(localComposite, b("ftpPasswd.SetDialog")).setLayoutData(b(100));
    this.G = a(localComposite, 2048);
    this.G.setLayoutData(b(240));
    this.G.setEchoChar('*');
    this.G.setText(b.a().s());
    a(localComposite, b("ftpRscPath.SetDialog")).setLayoutData(b(100));
    this.H = a(localComposite, 2048);
    this.H.setLayoutData(b(240));
    this.H.setText(b.a().t());
    a(localComposite, b("ftpJspPath.SetDialog")).setLayoutData(b(100));
    this.I = a(localComposite, 2048);
    this.I.setLayoutData(b(240));
    this.I.setText(b.a().r());
    a(localComposite, b("ftpRulesPath.SetDialog")).setLayoutData(b(100));
    this.J = a(localComposite, 2048);
    this.J.setLayoutData(b(240));
    this.J.setText(b.a().C());
    this.e = a(localComposite, "autoFtpExe.SetDialog", 32);
    this.e.setSelection(b.a().z());
    this.f = a(localComposite, "autoFtpPage.SetDialog", 32);
    this.f.setSelection(b.a().A());
    this.g = a(localComposite, "autoFtpRules.SetDialog", 32);
    this.g.setSelection(b.a().D());
  }

  private void g(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    a(localComposite, b("Driver.SetDialog")).setLayoutData(b(80));
    this.z = new Combo(localComposite, 4);
    this.z.setLayoutData(b(305));
    a(this.z);
    b(this.z);
    a(localComposite, b("URL.SetDialog")).setLayoutData(b(80));
    this.A = a(localComposite, 2048);
    this.A.setLayoutData(b(320));
    this.z.setText(b.a().k());
    this.A.setText(b.a().o());
    a(localComposite, b("UserName.SetDialog")).setLayoutData(b(80));
    this.B = a(localComposite, 2048);
    this.B.setLayoutData(b(320));
    this.B.setText(b.a().n());
    a(localComposite, b("Password.SetDialog")).setLayoutData(b(80));
    this.C = a(localComposite, 67584);
    this.C.setLayoutData(b(320));
    this.C.setEchoChar('*');
    this.C.setText(b.a().m());
    a(localComposite, b("ruleServiceUrl.SetDialog")).setLayoutData(b(80));
    this.D = a(localComposite, 2048);
    this.D.setLayoutData(b(320));
    this.D.setText(b.a().H());
    this.n = a(localComposite, "needLogin.SetDialog", 32);
    this.n.setSelection(BuilderConfig.getInstance().isFirstLogin());
    this.n.addSelectionListener(new K(this));
    this.o = a(localComposite, "loadDefault.SetDialog", 32);
    this.o.setSelection(BuilderConfig.getInstance().isLoadDefault());
    this.o.addSelectionListener(new B(this));
  }

  private void a(Combo paramCombo)
  {
    String[] arrayOfString = a.b("drivers");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      paramCombo.add(a.a(arrayOfString[i1] + ".Driver"));
    this.z.setVisibleItemCount(arrayOfString.length);
  }

  private void b(Combo paramCombo)
  {
    paramCombo.addModifyListener(new C(this, paramCombo));
  }

  protected void okPressed()
  {
    if (this.c != null)
      if (this.c.getSelection())
      {
        BuilderConfig.getInstance().setAutosave(true);
        BuilderConfig.getInstance().setAutosaveTime(new Long(this.r.getText()).longValue());
      }
      else
      {
        BuilderConfig.getInstance().setAutosave(false);
      }
    if (a("save"))
    {
      b.a().a(this.b.getSelection());
      b.a().c(this.p.getText());
      if (new File(this.p.getText()).exists())
        Property.getInstance().setRuleEngineClassDir(this.p.getText());
      else if (new File(FileUtil.getCurrentDir(), this.p.getText()).exists())
        Property.getInstance().setRuleEngineClassDir(new File(FileUtil.getCurrentDir(), this.p.getText()).getPath());
      b.a().b(this.q.getText());
      BuilderConfig.getInstance().setDemoKey(this.s.getText());
      b.a().b(this.d.getSelection());
    }
    if (a("server"))
    {
      if ((!b.a().k().equalsIgnoreCase(this.z.getText())) || (!b.a().o().equalsIgnoreCase(this.A.getText())) || (!b.a().n().equalsIgnoreCase(this.B.getText())) || (!b.a().m().equalsIgnoreCase(this.C.getText())))
      {
        b.a().d(this.z.getText());
        b.a().g(this.A.getText());
        b.a().f(this.B.getText());
        b.a().e(this.C.getText());
        this.a.getRulesManager().a(null, 0, 0);
      }
      if (!b.a().H().equals(this.D.getText()))
        this.a.getRulesManager().a(null, 0, 0);
      b.a().v(this.D.getText());
    }
    if (a("ftp"))
    {
      b.a().p(this.E.getText());
      b.a().q(this.F.getText());
      b.a().n(this.G.getText());
      b.a().o(this.H.getText());
      b.a().m(this.I.getText());
      b.a().u(this.J.getText());
      b.a().c(this.e.getSelection());
      b.a().d(this.f.getSelection());
      b.a().e(this.g.getSelection());
    }
    if (a("edit"))
    {
      b.a().h(this.t.getText());
      b.a().l(this.u.getText());
      b.a().i(this.v.getText());
      b.a().f(this.h.getSelection());
      b.a().g(this.i.getSelection());
      b.a().j(this.w.getText());
      b.a().a(this.x.getText());
    }
    if (this.a.isMainApplication())
    {
      b.a().b();
      BuilderConfig.getInstance().save();
    }
    super.okPressed();
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.z
 * JD-Core Version:    0.6.0
 */