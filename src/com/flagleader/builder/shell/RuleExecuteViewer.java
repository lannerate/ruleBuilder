package com.flagleader.builder.shell;

import com.flagleader.a.a.r;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.AboutLicenseDialog1;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.engine.IRuleEngineInfo;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.u;
import com.flagleader.server.ExecuteInfos;
import com.flagleader.server.RuleExecuteInfo;
import com.flagleader.server.d;
import com.flagleader.server.e;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.PrintStream;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class RuleExecuteViewer
{
  private Shell c;
  private Table d;
  private p e;
  private TableEditor f;
  String a;
  private FileDialog g;
  private Text h;
  StyledText b;
  private ToolBar i;
  private Menu j;
  private int k = 1;
  private Statement l = null;
  private boolean m = false;
  private i n;
  private Table o;
  private Composite p;
  private Composite q;
  private StyledText r;
  private int s = 0;
  private SashForm t;
  private CTabFolder u;
  private StringBuffer v = new StringBuffer();
  private ExecuteInfos w = new ExecuteInfos();
  private boolean x = false;
  private static File y = new File(FileUtil.getCurrentDir(), "excuter.rei");
  private static final Color z = new Color(null, 255, 0, 0);
  private static final Color A = new Color(null, 0, 0, 255);
  private static final Color B = new Color(null, 200, 200, 0);
  private static final Color C = new Color(null, 0, 128, 0);
  private static final Color D = new Color(null, 0, 0, 0);
  private Vector E = new Vector(30);
  private boolean F = false;

  private RuleExecuteViewer()
  {
    if (new File(d(b.a().f())).exists())
      try
      {
        if (Property.getInstance().getRuleEngineJarsDir().length() > 0)
          Property.getInstance().setRuleEngineJarsDir(Property.getInstance().getRuleEngineJarsDir() + d(b.a().f()) + StringUtil.classPathAdd());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
  }

  private static String d(String paramString)
  {
    if (new File(FileUtil.getCurrentDir(), paramString).exists())
      return new File(FileUtil.getCurrentDir(), paramString).getAbsolutePath();
    return paramString;
  }

  private Menu j()
  {
    Menu localMenu1 = this.c.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(e("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new cC(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("SaveItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new cN(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new cW(this));
    return localMenu2;
  }

  private static String e(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  Menu a()
  {
    Menu localMenu1 = this.c.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("StartItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new cX(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("StopItem"));
    localMenuItem.setAccelerator(16777229);
    localMenuItem.addSelectionListener(new cY(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("AddItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    localMenuItem.addSelectionListener(new cZ(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("edit.popup"));
    localMenuItem.setAccelerator(SWT.MOD1 + 69);
    localMenuItem.addSelectionListener(new da(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("DeleteItem"));
    localMenuItem.setAccelerator(127);
    localMenuItem.addSelectionListener(new db(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("update.popup"));
    localMenuItem.setAccelerator(16777233);
    localMenuItem.addSelectionListener(new dc(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("AboutItem"));
    localMenuItem.addSelectionListener(new cD(this));
    return localMenu2;
  }

  void b()
  {
    this.i = new ToolBar(this.c, 0);
    ToolItem localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("TestItem.icon"));
    localToolItem.addSelectionListener(new cE(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("stop.icon"));
    localToolItem.addSelectionListener(new cF(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("add.icon"));
    localToolItem.addSelectionListener(new cG(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("PropertiesItem.icon"));
    localToolItem.addSelectionListener(new cH(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("DeleteItem.icon"));
    localToolItem.addSelectionListener(new cI(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("UpdateItem.icon"));
    localToolItem.addSelectionListener(new cJ(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("AboutItem.icon"));
    localToolItem.addSelectionListener(new cK(this));
  }

  void c()
  {
    Menu localMenu = new Menu(this.c, 2);
    this.c.setMenuBar(localMenu);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 64);
    localMenuItem1.setText(e("FileMenu"));
    localMenuItem1.setMenu(j());
    MenuItem localMenuItem2 = new MenuItem(localMenu, 64);
    localMenuItem2.setText(e("EditMenu"));
    localMenuItem2.setMenu(a());
  }

  void a(Display paramDisplay)
  {
    this.c = new Shell(paramDisplay);
    this.c.setText(e("title.RuleExecuteViewer") + c.b("builderversion", "3.0.0"));
    this.c.setImage(ResourceTools.getImage("builder.icon"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.c.setLayout(localGridLayout);
    this.c.addShellListener(new cL(this));
  }

  private void k()
  {
    Composite localComposite = new Composite(this.c, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.t = new SashForm(localComposite, 512);
    this.t.setLayout(h.a(1));
    this.t.setLayoutData(new GridData(1808));
    this.p = new Composite(this.t, 2048);
    this.p.setBackground(h.d);
    this.p.setLayout(h.a(1));
    this.p.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(this.p, 8389504);
    localCTabFolder.setLayoutData(new GridData(1808));
    CTabItem localCTabItem1 = new CTabItem(localCTabFolder, 0);
    localCTabItem1.setText(e("itemRule.RuleExecuteViewer"));
    a(localCTabFolder);
    localCTabItem1.setControl(this.d);
    localCTabFolder.setSelection(localCTabItem1);
    this.q = new Composite(this.t, 2048);
    this.q.setBackground(h.d);
    this.q.setLayout(h.a(1));
    this.q.setLayoutData(new GridData(1808));
    this.u = new CTabFolder(this.q, 8389504);
    this.u.setLayoutData(new GridData(1808));
    CTabItem localCTabItem2 = new CTabItem(this.u, 0);
    localCTabItem2.setText(ResourceTools.getMessage("loginfo.RuleExecuteViewer"));
    localCTabItem2.setControl(m());
    CTabItem localCTabItem3 = new CTabItem(this.u, 0);
    localCTabItem3.setText(e("logrule.RuleExecuteViewer"));
    localCTabItem3.setControl(r());
    CTabItem localCTabItem4 = new CTabItem(this.u, 0);
    localCTabItem4.setText(e("runinfo.RuleExecuteViewer"));
    localCTabItem4.setControl(e());
    CTabItem localCTabItem5 = new CTabItem(this.u, 0);
    localCTabItem5.setText(ResourceTools.getMessage("ruleinfo.RuleServerTray"));
    localCTabItem5.setControl(l());
    this.u.setSelection(localCTabItem2);
    this.u.addSelectionListener(new cM(this));
    this.t.setWeights(new int[] { 40, 60 });
  }

  private Composite l()
  {
    Composite localComposite = new Composite(this.u, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    new df(localComposite).b();
    return localComposite;
  }

  private Composite m()
  {
    Composite localComposite = new Composite(this.u, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.b = new af(localComposite, 2882).m();
    this.b.setLayoutData(new GridData(1808));
    de localde = new de(this);
    localde.setLevel(Level.ALL);
    Logger localLogger = Logger.getLogger("ruleengine");
    localLogger.addHandler(localde);
    cO localcO = new cO(this);
    this.u.getDisplay().timerExec(1000, localcO);
    return localComposite;
  }

  void a(Composite paramComposite)
  {
    i locali = new i(false, true);
    this.d = locali.a(paramComposite, 66306);
    this.d.setLayoutData(new GridData(1808));
    this.d.setHeaderVisible(true);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = d();
    String[] arrayOfString2 = ResourceTools.getStringArray("types.RuleExecuteViewer");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.RuleExecuteViewer");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    locali.a(arrayOfString1, arrayOfInt, arrayOfString2);
    TableEditor localTableEditor = new TableEditor(this.d);
    this.d.addMouseListener(new cP(this));
  }

  private void n()
  {
    File localFile = new File("ruleexecute.log");
    if ((localFile == null) || (this.r.isDisposed()))
      return;
    try
    {
      this.r.setText(FileUtil.readFromFile(localFile));
      this.r.setSelection(this.r.getText().length());
    }
    catch (Exception localException)
    {
    }
  }

  private void o()
  {
    TableItem[] arrayOfTableItem = this.d.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      ((RuleExecuteInfo)arrayOfTableItem[i1].getData()).setStoped(false);
  }

  private void p()
  {
    TableItem[] arrayOfTableItem = this.d.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
      ((RuleExecuteInfo)arrayOfTableItem[i1].getData()).setStoped(true);
  }

  protected String[] d()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.RuleExecuteViewer");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString[i1] + ".RuleExecuteViewer") == null)
        continue;
      arrayOfString[i1] = ResourceTools.getMessage(arrayOfString[i1] + ".RuleExecuteViewer");
    }
    return arrayOfString;
  }

  private boolean a(RuleExecuteInfo paramRuleExecuteInfo)
  {
    TableItem localTableItem = new TableItem(this.d, 0);
    a(localTableItem, paramRuleExecuteInfo);
    paramRuleExecuteInfo.setViewer(new cS(this));
    if (paramRuleExecuteInfo.getState() != 3)
      paramRuleExecuteInfo.setStoped(false);
    return true;
  }

  private void q()
  {
  }

  private Composite r()
  {
    Composite localComposite = new Composite(this.u, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.r = new af(localComposite, 2882).m();
    this.r.setLayoutData(new GridData(1808));
    return localComposite;
  }

  public Composite e()
  {
    Composite localComposite = new Composite(this.u, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.n = new i(true, true);
    this.o = this.n.a(localComposite, 66304);
    this.o.setLayoutData(new GridData(1808));
    this.o.setHeaderVisible(true);
    this.o.setLinesVisible(true);
    g();
    this.o.addMouseListener(new cT(this));
    return localComposite;
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.c, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  public static RuleExecuteViewer f()
  {
    if (new File("execute.lck").exists())
      if (!MessageDialog.openConfirm(null, "", ResourceTools.formatMessage("existlock.RuleExecuteViewer", new String[] { "execute.lck" })))
        return null;
    try
    {
      new File("execute.lck").createNewFile();
    }
    catch (Exception localException)
    {
    }
    RuleExecuteViewer localRuleExecuteViewer = new RuleExecuteViewer();
    Shell localShell = localRuleExecuteViewer.b(null);
    localShell.addDisposeListener(new cV());
    Display localDisplay = localShell.getDisplay();
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
    return localRuleExecuteViewer;
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    c();
    b();
    k();
    this.c.setSize(1024, 700);
    this.c.open();
    if (r.a("ruleengine.rlc"))
    {
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    }
    else
    {
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
      AboutLicenseDialog1 localAboutLicenseDialog1 = new AboutLicenseDialog1(this.c);
      localAboutLicenseDialog1.open();
    }
    RuleEngineFactory.newInstance();
    y();
    return this.c;
  }

  public void g()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("threadcolumns.RuleExecuteViewer");
    for (int i1 = 0; i1 < arrayOfString1.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString1[i1] + ".RuleExecuteViewer") == null)
        continue;
      arrayOfString1[i1] = ResourceTools.getMessage(arrayOfString1[i1] + ".RuleExecuteViewer");
    }
    String[] arrayOfString2 = ResourceTools.getStringArray("threadtypes.RuleExecuteViewer");
    String[] arrayOfString3 = ResourceTools.getStringArray("threadlengths.RuleExecuteViewer");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i2 = 0; i2 < arrayOfString3.length; i2++)
      arrayOfInt[i2] = Integer.parseInt(arrayOfString3[i2]);
    this.n.a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  private void s()
  {
    this.d.removeAll();
    if (this.w == null)
      return;
    List localList = this.w.getInfos();
    for (int i1 = 0; i1 < localList.size(); i1++)
      a((RuleExecuteInfo)localList.get(i1));
  }

  private void t()
  {
    TableItem[] arrayOfTableItem = this.d.getItems();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      TableItem localTableItem = arrayOfTableItem[i1];
      RuleExecuteInfo localRuleExecuteInfo = (RuleExecuteInfo)localTableItem.getData();
      a(localTableItem, localRuleExecuteInfo);
    }
    System.gc();
    z();
  }

  private void u()
  {
    this.o.removeAll();
    ArrayList localArrayList = new ArrayList(ExecuteInfos.getRecords().size());
    localArrayList.addAll(ExecuteInfos.getRecords());
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
    {
      TableItem localTableItem = new TableItem(this.o, 0);
      IRuleEngineInfo localIRuleEngineInfo = (IRuleEngineInfo)localArrayList.get(i1);
      localTableItem.setText(0, localIRuleEngineInfo.getRuleName());
      localTableItem.setText(1, localIRuleEngineInfo.getStarttime());
      localTableItem.setText(2, localIRuleEngineInfo.isHasRun() ? u.a("running.RuleExecuteInfo") : u.a("waiting.RuleExecuteInfo"));
      localTableItem.setText(3, localIRuleEngineInfo.getInfo());
    }
  }

  private void a(TableItem paramTableItem, RuleExecuteInfo paramRuleExecuteInfo)
  {
    paramTableItem.setText(0, paramRuleExecuteInfo.getDisplayName());
    paramTableItem.setText(1, paramRuleExecuteInfo.getExeRuleName());
    paramTableItem.setText(2, paramRuleExecuteInfo.getPlanInfo());
    paramTableItem.setText(3, paramRuleExecuteInfo.getStopInfo());
    if (paramRuleExecuteInfo.getStartTime() > 0L)
      paramTableItem.setText(4, Property.getInstance().formatDatetime(new Date(paramRuleExecuteInfo.getStartTime())));
    paramTableItem.setText(5, paramRuleExecuteInfo.getStateInfo());
    if (paramRuleExecuteInfo.getLastTime() > 0L)
      paramTableItem.setText(6, Property.getInstance().formatDatetime(new Date(paramRuleExecuteInfo.getLastTime())));
    if (paramRuleExecuteInfo.getErrorInfo().length() > 0)
    {
      paramTableItem.setText(7, paramRuleExecuteInfo.getErrorInfo());
      paramTableItem.setForeground(7, B);
    }
    else
    {
      paramTableItem.setText(7, paramRuleExecuteInfo.getSuccessInfo());
      paramTableItem.setForeground(7, D);
    }
    paramTableItem.setData(paramRuleExecuteInfo);
    if (paramRuleExecuteInfo.isStoped())
      paramTableItem.setForeground(3, z);
    else
      paramTableItem.setForeground(3, A);
  }

  private void v()
  {
    M localM = new M();
    if ((localM.open() == 0) && (localM.l().length() > 0))
    {
      RuleExecuteInfo localRuleExecuteInfo = new RuleExecuteInfo();
      localRuleExecuteInfo.setExeRuleName(localM.l());
      localRuleExecuteInfo.setInternalTime(localM.m());
      localRuleExecuteInfo.setDisplayName(localM.k());
      localRuleExecuteInfo.setPlanType(localM.q());
      localRuleExecuteInfo.setSpecialDay(localM.o());
      localRuleExecuteInfo.setSpecialTime(localM.p());
      localRuleExecuteInfo.setTracelogtype(localM.s());
      localRuleExecuteInfo.setAdvanceProperties(localM.n());
      this.w.addRuleExecuteInfo(localRuleExecuteInfo);
      a(localRuleExecuteInfo);
    }
  }

  private void w()
  {
    if ((this.d.getSelection().length > 0) && ((this.d.getSelection()[0].getData() instanceof RuleExecuteInfo)))
    {
      TableItem localTableItem = this.d.getSelection()[0];
      RuleExecuteInfo localRuleExecuteInfo = (RuleExecuteInfo)localTableItem.getData();
      M localM = new M(localRuleExecuteInfo);
      if ((localM.open() == 0) && (localM.l().length() > 0))
      {
        localRuleExecuteInfo.setExeRuleName(localM.l());
        localRuleExecuteInfo.setInternalTime(localM.m());
        localRuleExecuteInfo.setDisplayName(localM.k());
        localRuleExecuteInfo.setPlanType(localM.q());
        localRuleExecuteInfo.setSpecialDay(localM.o());
        localRuleExecuteInfo.setSpecialTime(localM.p());
        localRuleExecuteInfo.setTracelogtype(localM.s());
        localRuleExecuteInfo.setLastTime(0L);
        localRuleExecuteInfo.setStartTime(0L);
        localRuleExecuteInfo.setAdvanceProperties(localM.n());
        a(localTableItem, localRuleExecuteInfo);
      }
    }
  }

  private void x()
  {
    if ((this.d.getSelection().length > 0) && ((this.d.getSelection()[0].getData() instanceof RuleExecuteInfo)))
      for (int i1 = this.d.getSelection().length - 1; i1 >= 0; i1--)
      {
        TableItem localTableItem = this.d.getSelection()[i1];
        RuleExecuteInfo localRuleExecuteInfo = (RuleExecuteInfo)localTableItem.getData();
        localRuleExecuteInfo.setStoped(true);
        this.w.romoveMethod(localRuleExecuteInfo);
        localTableItem.dispose();
      }
  }

  public static void main(String[] paramArrayOfString)
  {
    if (new File(d(b.a().f())).exists())
      try
      {
        if (Property.getInstance().getRuleEngineJarsDir().length() > 0)
          Property.getInstance().setRuleEngineJarsDir(Property.getInstance().getRuleEngineJarsDir() + d(b.a().f()) + StringUtil.classPathAdd());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    Display localDisplay = Display.getDefault();
    if (r.a("ruleengine.rlc"))
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    else
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
    RuleEngineFactory.newInstance();
    b.a().h(false);
    RuleExecuteViewer localRuleExecuteViewer = f();
    if ((localRuleExecuteViewer != null) && (paramArrayOfString.length > 0))
      localRuleExecuteViewer.b(paramArrayOfString[0]);
  }

  void h()
  {
    if (this.g == null)
      this.g = new FileDialog(this.c, 4096);
    this.g.setFilterExtensions(new String[] { "*.rei", "*.*" });
    String str = this.g.open();
    b(str);
  }

  private void y()
  {
    if (y.exists())
      b(y.getPath());
  }

  private void z()
  {
    try
    {
      c(y.getPath());
    }
    catch (Exception localException)
    {
      System.out.println(localException.getMessage());
    }
  }

  void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    Object localObject;
    if (!localFile.exists())
    {
      localObject = MessageFormat.format(e("Err_file_no_exist"), new String[] { localFile.getName() });
      a((String)localObject);
      return;
    }
    try
    {
      if (this.w != null)
      {
        localObject = this.w.getInfos();
        for (int i1 = 0; i1 < ((List)localObject).size(); i1++)
          ((RuleExecuteInfo)((List)localObject).get(i1)).setStoped(true);
      }
      this.w = ((ExecuteInfos)new d().load(localFile));
    }
    catch (Exception localException)
    {
      String str = MessageFormat.format(e("Err_file_io"), new String[] { localFile.getName() });
      a(str);
      this.w = new ExecuteInfos();
    }
    this.a = paramString;
    s();
  }

  public void c(String paramString)
  {
    if (paramString != null)
    {
      File localFile = new File(paramString);
      e locale = new e(localFile);
      locale.a(this.w);
      locale.close();
    }
  }

  void i()
  {
    this.c.close();
  }

  private void a(String paramString, Level paramLevel)
  {
    paramString = Property.getInstance().formatDatetime(new Date()) + " : " + paramString;
    if (paramString.indexOf("\n") < 0)
      this.E.add(paramString + "\n");
    else
      this.E.add(paramString);
    this.F = true;
  }

  private void A()
  {
    if ((this.b.isDisposed()) || (!this.F))
      return;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = this.E.size() - 1; i1 >= 0; i1--)
      localStringBuffer.append(this.E.get(i1));
    this.b.setText(localStringBuffer.toString());
    while (this.E.size() > 30)
      this.E.remove(0);
    this.F = false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.RuleExecuteViewer
 * JD-Core Version:    0.6.0
 */