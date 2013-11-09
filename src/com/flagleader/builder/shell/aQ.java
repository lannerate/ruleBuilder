package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.a.t;
import com.flagleader.builder.widget.editor.n;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.Property;
import com.flagleader.export.PagePreferences;
import com.flagleader.export.PagePropertyPool;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.export.d;
import com.flagleader.repository.export.f;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class aQ
{
  Shell a;
  private StyledText h;
  private StyledText i;
  Composite b;
  p c;
  p d;
  private String j;
  private String k = PagePropertyPool.getRSPDIR();
  t e = null;
  ToolBar f;
  CTabItem g;
  private Composite l;
  private Composite m;
  private int n = 0;
  private SashForm o;
  private int[] p;
  private CTabFolder q;
  private CTabItem r;
  private ToolItem s;
  private ToolItem t;
  private boolean u = true;
  private HashMap v = new HashMap();
  private Tree w = null;

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(e("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new aR(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(e("SaveItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new bc(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(e("ReCompileItem"));
    localMenuItem.addSelectionListener(new bl(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new bm(this));
    return localMenu2;
  }

  private String e(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  private p m()
  {
    if ((this.q.getItemCount() > 0) && (this.q.getItem(0).getControl() != null) && ((this.q.getItem(0).getControl().getData() instanceof p)))
      return (p)this.q.getItem(0).getControl().getData();
    return null;
  }

  Menu b()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("UndoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new bn(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("RedoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new bo(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("CutItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new bp(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("CopyItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem.addSelectionListener(new bq(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("PasteItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    localMenuItem.addSelectionListener(new br(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("FindItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new aS(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("FindNextItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new aT(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("updatetree.RspEditor"));
    localMenuItem.setAccelerator(16777230);
    localMenuItem.setSelection(this.u);
    localMenuItem.addSelectionListener(new aU(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(e("CompileItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new aV(this));
    return localMenu2;
  }

  void c()
  {
    this.f = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.f, 8);
    localToolItem.setImage(ResourceTools.getImage("OpenItem.icon"));
    localToolItem.addSelectionListener(new aW(this));
    this.s = new ToolItem(this.f, 8);
    this.s.setImage(ResourceTools.getImage("SaveItem.icon"));
    this.s.addSelectionListener(new aX(this));
    this.t = new ToolItem(this.f, 8);
    this.t.setImage(ResourceTools.getImage("SaveAllItem.icon"));
    this.t.addSelectionListener(new aY(this));
    localToolItem = new ToolItem(this.f, 2);
    localToolItem = new ToolItem(this.f, 8);
    localToolItem.setImage(ResourceTools.getImage("cut.icon"));
    localToolItem.addSelectionListener(new aZ(this));
    localToolItem = new ToolItem(this.f, 8);
    localToolItem.setImage(ResourceTools.getImage("copy.icon"));
    localToolItem.addSelectionListener(new ba(this));
    localToolItem = new ToolItem(this.f, 8);
    localToolItem.setImage(ResourceTools.getImage("paste.icon"));
    localToolItem.addSelectionListener(new bb(this));
    localToolItem = new ToolItem(this.f, 2);
    localToolItem = new ToolItem(this.f, 8);
    localToolItem.setImage(ResourceTools.getImage("exportcompile.icon"));
    localToolItem.addSelectionListener(new bd(this));
  }

  void d()
  {
    if ((m() != null) && (m().b().b()))
      this.s.setEnabled(true);
    else
      this.s.setEnabled(false);
    if (l())
      this.t.setEnabled(true);
    else
      this.t.setEnabled(false);
  }

  void e()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 64);
    localMenuItem1.setText(e("FileMenu"));
    localMenuItem1.setMenu(a());
    MenuItem localMenuItem2 = new MenuItem(localMenu, 64);
    localMenuItem2.setText(e("EditMenu"));
    localMenuItem2.setMenu(b());
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(e("title.RspEditor"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new be(this));
  }

  private void a(Composite paramComposite)
  {
    SashForm localSashForm = new SashForm(paramComposite, 256);
    localSashForm.setLayout(new FillLayout());
    b(localSashForm);
    c(localSashForm);
    localSashForm.setWeights(new int[] { 20, 80 });
  }

  private void b(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.w = new com.flagleader.builder.widget.s().a(localComposite, 2818);
    this.w.setLayoutData(new GridData(1808));
    this.w.setHeaderVisible(false);
    this.w.addMouseListener(new bf(this));
  }

  public TreeItem f()
  {
    if ((this.w != null) && (this.w.getSelection() != null) && (this.w.getSelection().length == 1))
      return this.w.getSelection()[0];
    return null;
  }

  private void c(Composite paramComposite)
  {
    this.l = new Composite(paramComposite, 2048);
    this.l.setBackground(h.d);
    this.l.setLayout(h.a(1));
    this.l.setLayoutData(new GridData(1808));
    this.q = new CTabFolder(this.l, 8389504);
    this.q.setLayoutData(new GridData(1808));
    this.g = new CTabItem(this.q, 0);
    this.g.setText(e("model_source_text"));
    this.g.setControl(a(this.q, "", false));
    this.r = new CTabItem(this.q, 0);
    this.r.setText(e("model_output_text"));
    this.r.setControl(a(this.q));
    this.q.setSelection(this.g);
    this.q.addSelectionListener(new bg(this));
  }

  private void n()
  {
    Composite localComposite1 = new Composite(this.a, 0);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    this.o = new SashForm(localComposite1, 512);
    this.o.setLayout(h.a(1));
    this.o.setLayoutData(new GridData(1808));
    a(this.o);
    this.m = new Composite(this.o, 2048);
    this.m.setBackground(h.d);
    this.m.setLayout(h.a(1));
    this.m.setLayoutData(new GridData(1808));
    Composite localComposite2 = new Composite(this.m, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    this.d = com.flagleader.builder.widget.editor.s.a(0, null, localComposite2, 2882);
    this.h = this.d.a();
    this.h.setLayoutData(new GridData(1808));
    this.h.addMouseMoveListener(new bh(this));
    this.h.addMouseListener(new bi(this));
    this.o.setWeights(new int[] { 90, 10 });
  }

  private Composite a(CTabFolder paramCTabFolder, String paramString, boolean paramBoolean)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    int i1 = 2818;
    if (!paramBoolean)
      i1 |= 8;
    if (this.u)
      i1 = 68162;
    p localp = com.flagleader.builder.widget.editor.s.a(5, null, localComposite, i1, new bj(this, paramString));
    if (!paramBoolean)
      localp.a().setEditable(false);
    localComposite.setData(localp);
    return localComposite;
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    if (this.b != null)
      return this.b;
    this.b = new Composite(paramCTabFolder, 0);
    this.b.setLayout(new GridLayout());
    this.b.setLayoutData(new GridData(1808));
    this.c = com.flagleader.builder.widget.editor.s.a(1, null, this.b, 2818);
    this.i = this.c.a();
    this.i.setLayoutData(new GridData(1808));
    this.i.setText("");
    this.i.setEditable(false);
    return this.b;
  }

  void a(String paramString)
  {
    MessageDialog.openError(this.a, "", paramString);
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    e();
    c();
    n();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  private void o()
  {
    f localf = new f();
    try
    {
      if (m() != null)
      {
        localf.c(m().a().getText());
        this.i.setText(localf.k());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void f(String paramString)
  {
    this.a.getDisplay().asyncExec(new bk(this, paramString));
  }

  private void p()
  {
    Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getActiveShell().getDisplay().getSystemCursor(1));
    String[] arrayOfString = new PagesMessages(null, "pages").getStringArray("rspTemplates.choise");
    for (int i1 = 0; (arrayOfString != null) && (i1 < arrayOfString.length); i1++)
      f(arrayOfString[i1]);
    arrayOfString = PagePreferences.getPreferences("ajax").getStringArray("rspTemplates.choise");
    for (i1 = 0; (arrayOfString != null) && (i1 < arrayOfString.length); i1++)
      f(arrayOfString[i1]);
    Display.getCurrent().getActiveShell().setCursor(null);
  }

  private String d(String paramString1, String paramString2)
  {
    if (paramString1.length() > 0)
    {
      if (paramString1.indexOf("/") > 0)
        return paramString1.substring(0, paramString1.indexOf("/") + 1) + paramString2 + paramString1.substring(paramString1.indexOf("/") + 1);
      return paramString2 + paramString1;
    }
    return "";
  }

  private void q()
  {
    bt localbt = new bt(this);
    localbt.setLevel(Level.ALL);
    Logger localLogger = Logger.getLogger("flagleader");
    localLogger.addHandler(localbt);
    Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getActiveShell().getDisplay().getSystemCursor(1));
    f localf = new f();
    try
    {
      if (m() != null)
      {
        localf.c(m().a().getText());
        this.i.setText(localf.k());
        this.q.setSelection(this.r);
        this.h.setText("编译正确,没有错误!");
      }
    }
    catch (Throwable localThrowable)
    {
      e(localf.k(), localThrowable.getLocalizedMessage());
    }
    finally
    {
      localLogger.removeHandler(localbt);
      Display.getCurrent().getActiveShell().setCursor(null);
    }
  }

  private void e(String paramString1, String paramString2)
  {
    this.h.setText(paramString2);
    Vector localVector = new Vector();
    Object localObject = new StringTokenizer(paramString2, "\n\r");
    while (((StringTokenizer)localObject).hasMoreTokens())
      localVector.addElement(((StringTokenizer)localObject).nextToken());
    localObject = new Vector();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "\n\r");
    while (localStringTokenizer.hasMoreTokens())
      ((Vector)localObject).addElement(localStringTokenizer.nextToken());
    this.p = new int[localVector.size()];
    for (int i1 = 0; i1 < this.p.length; i1++)
    {
      String str1 = localVector.get(i1).toString();
      if (str1.indexOf(".java:") > 0)
      {
        String str2 = str1.substring(str1.indexOf(".java:") + 6, str1.indexOf(":", str1.indexOf(".java:") + 6));
        try
        {
          this.p[i1] = this.i.getOffsetAtLine(Integer.parseInt(str2));
        }
        catch (Exception localException)
        {
          this.p[i1] = -1;
        }
      }
      else
      {
        this.p[i1] = -1;
      }
    }
  }

  void g()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.rsp" });
    String str = localFileDialog.open();
    if (str != null)
      b(str);
  }

  void h()
  {
    if ((this.q.getItemCount() > 0) && ((this.q.getItem(0).getControl().getData() instanceof p)))
    {
      p localp = (p)this.q.getItem(0).getControl().getData();
      String str = (String)this.q.getItem(0).getData();
      if (localp.b().b())
      {
        a(str, localp.a().getText());
        localp.b().a(false);
        d();
      }
    }
  }

  void i()
  {
    Iterator localIterator = this.v.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Composite localComposite = (Composite)this.v.get(str);
      if ((localComposite == null) || (localComposite.isDisposed()))
        continue;
      p localp = (p)localComposite.getData();
      if (!localp.b().b())
        continue;
      a(str, localp.a().getText());
      localp.b().a(false);
    }
    d();
  }

  public void a(TreeItem paramTreeItem)
  {
    if ((paramTreeItem.getData("modified") != null) && (paramTreeItem.getData("modified").equals("true")) && ((paramTreeItem.getData("path") instanceof File)) && (a((String)paramTreeItem.getData("path"), (String)paramTreeItem.getData("txt"))))
    {
      paramTreeItem.setData("modified", null);
      d();
    }
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i1 = 0; (arrayOfTreeItem != null) && (i1 < arrayOfTreeItem.length); i1++)
      a(arrayOfTreeItem[i1]);
  }

  boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      FileDialog localFileDialog = new FileDialog(this.a, 8192);
      localFileDialog.setFilterExtensions(new String[] { "*.rsp" });
      paramString1 = localFileDialog.open();
    }
    try
    {
      if (paramString1 != null)
      {
        FileUtil.saveToFile(paramString1, paramString2, Property.getInstance().getHtmlEncoding());
        return true;
      }
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(e("Err_file_io"), new String[] { this.j });
      a(str);
    }
    return false;
  }

  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      String str = MessageFormat.format(e("Err_not_found"), new String[] { localFile.getName() });
      a(str);
      return;
    }
    r();
    this.a.setText(paramString);
    this.j = paramString;
    if ((this.j.toLowerCase().startsWith(FileUtil.getCurrentDir().toLowerCase())) && (this.j.indexOf(File.separator, FileUtil.getCurrentDir().length() + 1) > 0))
    {
      this.k = this.j.substring(0, this.j.indexOf(File.separator, FileUtil.getCurrentDir().length() + 1));
    }
    else
    {
      this.k = g(new File(this.j).getParent());
      PagePropertyPool.setRSPDIR(this.k);
    }
    k();
    h(localFile.getPath());
    d();
  }

  private String g(String paramString)
  {
    File localFile = new File(paramString).getParentFile();
    if (new File(localFile, "pages.properties").exists())
      return localFile.getPath();
    return paramString;
  }

  private void b(URL paramURL)
  {
    if ((this.q.getItemCount() > 0) && (paramURL.equals(this.q.getItem(0).getData())))
      return;
    do
      this.q.getItem(0).dispose();
    while (this.q.getItemCount() > 0);
    Composite localComposite = (Composite)this.v.get(paramURL);
    this.g = new CTabItem(this.q, 0);
    this.g.setText(e("model_source_text"));
    if (localComposite != null)
    {
      this.g.setControl(localComposite);
    }
    else
    {
      localComposite = a(this.q, a(paramURL), false);
      this.g.setControl(localComposite);
    }
    this.g.setData(paramURL);
    this.r = new CTabItem(this.q, 0);
    this.r.setText(e("model_output_text"));
    this.r.setControl(a(this.q));
    this.q.setSelection(this.g);
  }

  private void h(String paramString)
  {
    if ((this.q.getItemCount() > 0) && (paramString.equals(this.q.getItem(0).getData())))
      return;
    do
      this.q.getItem(0).dispose();
    while (this.q.getItemCount() > 0);
    Composite localComposite = (Composite)this.v.get(paramString);
    this.g = new CTabItem(this.q, 0);
    this.g.setText(e("model_source_text"));
    if (localComposite != null)
    {
      this.g.setControl(localComposite);
    }
    else
    {
      localComposite = a(this.q, a(new File(paramString)), true);
      this.g.setControl(localComposite);
      this.v.put(paramString, localComposite);
    }
    this.g.setData(paramString);
    this.r = new CTabItem(this.q, 0);
    this.r.setText(e("model_output_text"));
    this.r.setControl(a(this.q));
    this.q.setSelection(this.g);
  }

  private void r()
  {
    Iterator localIterator = this.v.values().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)((Composite)localIterator.next()).getData();
      localp.a().dispose();
    }
    this.v.clear();
  }

  void j()
  {
    this.a.close();
  }

  String c(String paramString)
  {
    File localFile = new File(paramString);
    return localFile.getName().substring(0, localFile.getName().length() - 4);
  }

  void k()
  {
    this.w.removeAll();
    TreeItem localTreeItem = new TreeItem(this.w, 0);
    localTreeItem.setText(c(this.j));
    localTreeItem.setData("path", new File(this.j));
    String str = a(new File(this.j));
    localTreeItem.setData("txt", str);
    a(localTreeItem, str);
    localTreeItem.setExpanded(true);
  }

  void a(TreeItem paramTreeItem, String paramString)
  {
    String str1 = "call ";
    int i1 = paramString.indexOf("<?" + str1);
    int i2 = paramString.indexOf("?>", i1 + str1.length() + 2);
    if ((i1 < 0) || ((paramString.indexOf("<?" + str1) > paramString.indexOf("<?include ")) && (paramString.indexOf("<?include ") >= 0)))
    {
      str1 = "include ";
      i1 = paramString.indexOf("<?" + str1);
      i2 = paramString.indexOf("?>", i1 + str1.length() + 2);
    }
    while ((i1 >= 0) && (i2 > i1))
    {
      String str2 = paramString.substring(i1 + str1.length() + 2, i2).trim();
      String str3 = "";
      if (str2.endsWith(";"))
        str2 = str2.substring(0, str2.length() - 1);
      Object localObject = null;
      try
      {
        if (new File(this.k, str2).exists())
        {
          localObject = new File(this.k, str2);
          str3 = FileUtil.readFromFile(new File(this.k, str2));
        }
        else if ((getClass().getClassLoader().getResource(str2) != null) && (getClass().getClassLoader().getResource(str2).getPath() != null))
        {
          localObject = getClass().getClassLoader().getResource(str2);
          str3 = FileUtil.readFromStream(d.class.getClassLoader().getResourceAsStream(str2));
        }
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "", str2 + "not exits:" + localIOException.getLocalizedMessage());
      }
      TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
      if (str1.length() > 5)
        localTreeItem.setForeground(h.a);
      if ((localObject instanceof URL))
        localTreeItem.setGrayed(true);
      localTreeItem.setText(c(str2));
      localTreeItem.setData("path", localObject);
      localTreeItem.setData("txt", str3);
      a(localTreeItem, str3);
      if ((paramString.indexOf("<?call ", i2) >= 0) && ((paramString.indexOf("<?call ", i2) < paramString.indexOf("<?include ", i2)) || (paramString.indexOf("<?include ", i2) < 0)))
      {
        str1 = "call ";
        i1 = paramString.indexOf("<?" + str1, i2);
        i2 = paramString.indexOf("?>", i1 + str1.length() + 2);
      }
      else
      {
        str1 = "include ";
        i1 = paramString.indexOf("<?" + str1, i2);
        i2 = paramString.indexOf("?>", i1 + str1.length() + 2);
      }
    }
  }

  String a(URL paramURL)
  {
    try
    {
      return FileUtil.readFromStream(paramURL.openStream());
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(e("Err_file_io"), new String[] { paramURL.getPath() });
      a(str);
    }
    return "";
  }

  String a(File paramFile)
  {
    try
    {
      return FileUtil.readFromFile(paramFile);
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(e("Err_file_io"), new String[] { paramFile.getName() });
      a(str);
    }
    return "";
  }

  private void a(String paramString, Level paramLevel)
  {
    if (!this.h.isDisposed())
      this.h.append(paramString + "\n");
    this.h.setSelection(this.h.getText().length());
  }

  public boolean l()
  {
    Iterator localIterator = this.v.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Composite localComposite = (Composite)this.v.get(str);
      if ((localComposite == null) || (localComposite.isDisposed()))
        continue;
      p localp = (p)localComposite.getData();
      if (localp.b().b())
        return true;
    }
    return false;
  }

  public boolean b(TreeItem paramTreeItem)
  {
    if ((paramTreeItem.getData("modified") != null) && (paramTreeItem.getData("modified").equals("true")))
      return true;
    TreeItem[] arrayOfTreeItem = paramTreeItem.getItems();
    for (int i1 = 0; (arrayOfTreeItem != null) && (i1 < arrayOfTreeItem.length); i1++)
      if (b(arrayOfTreeItem[i1]))
        return true;
    return false;
  }

  boolean d(String paramString)
  {
    int i1 = b(paramString, "<?");
    int i2 = b(paramString, "?>");
    String str;
    if (i1 != i2)
    {
      str = MessageFormat.format(e("Err_tag_num"), new String[] { String.valueOf(i1), String.valueOf(i2) });
      a(str);
      return false;
    }
    i1 = c(paramString, "{");
    i2 = c(paramString, "}");
    if (i1 != i2)
    {
      str = MessageFormat.format(e("Err_kuohao_num"), new String[] { String.valueOf(i1), String.valueOf(i2) });
      a(str);
      return false;
    }
    return true;
  }

  int b(String paramString1, String paramString2)
  {
    int i1 = 0;
    int i2 = 0;
    for (i1 = paramString1.indexOf(paramString2); i1 != -1; i1 = paramString1.indexOf(paramString2, i1 + paramString2.length()))
      i2++;
    return i2;
  }

  int c(String paramString1, String paramString2)
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    for (i1 = paramString1.indexOf("<?"); i1 != -1; i1 = paramString1.indexOf("<?", i2 + 2))
    {
      i2 = paramString1.indexOf("?>", i1);
      i3 += b(paramString1.substring(i1 + 2, i2), paramString2);
    }
    return i3;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aQ
 * JD-Core Version:    0.6.0
 */