package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.engine.Property;
import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMember;
import com.flagleader.repository.lang.info.InfoMethod;
import com.flagleader.util.RuleClassLoader;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ClassInfoEditor
{
  Shell a;
  private StyledText k;
  private StyledText l;
  Composite b;
  com.flagleader.builder.widget.editor.p c;
  com.flagleader.builder.widget.editor.p d;
  String e;
  com.flagleader.builder.widget.a.t f = null;
  ToolBar g;
  private Composite m;
  private Composite n;
  private int o = 0;
  private SashForm p;
  private int[] q;
  private CTabFolder r;
  private CTabItem s;
  CTabItem h;
  private HashMap t = new HashMap();
  private Table u;
  private ToolItem v;
  private ToolItem w;
  private boolean x = true;
  Menu i;
  private Tree y = null;
  private List z = com.flagleader.repository.lang.info.a.b().c();
  private Text A = null;
  private HashMap B = new HashMap();
  TreeEditor j = null;

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new a(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("SaveItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new q(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("ReCompileItem"));
    localMenuItem.addSelectionListener(new y(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new z(this));
    return localMenu2;
  }

  private String c(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  private com.flagleader.builder.widget.editor.p k()
  {
    if ((this.r.getItemCount() > 0) && (this.r.getItem(1).getControl() != null) && ((this.r.getItem(1).getControl().getData() instanceof com.flagleader.builder.widget.editor.p)))
      return (com.flagleader.builder.widget.editor.p)this.r.getItem(1).getControl().getData();
    return null;
  }

  Menu b()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("UndoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new A(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("RedoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new B(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("FindItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new C(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("FindNextItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new D(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CompileItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new E(this));
    return localMenu2;
  }

  void c()
  {
    this.g = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.g, 8);
    localToolItem.setImage(ResourceTools.getImage("OpenItem.icon"));
    localToolItem.addSelectionListener(new b(this));
    this.v = new ToolItem(this.g, 8);
    this.v.setImage(ResourceTools.getImage("SaveItem.icon"));
    this.v.addSelectionListener(new c(this));
    this.w = new ToolItem(this.g, 8);
    this.w.setImage(ResourceTools.getImage("SaveAllItem.icon"));
    this.w.addSelectionListener(new d(this));
    localToolItem = new ToolItem(this.g, 2);
    localToolItem = new ToolItem(this.g, 8);
    localToolItem.setImage(ResourceTools.getImage("exportcompile.icon"));
    localToolItem.addSelectionListener(new e(this));
  }

  void d()
  {
    if ((this.r.getItemCount() > 0) && (this.r.getItem(0).getData() != null))
    {
      if ((((InfoClass)this.r.getItem(0).getData()).isModified()) || ((this.r.getItem(1).getControl() != null) && (this.r.getItem(1).getControl().getData() != null) && (((com.flagleader.builder.widget.editor.p)this.r.getItem(1).getControl().getData()).b().b())))
        this.v.setEnabled(true);
      else
        this.v.setEnabled(false);
    }
    else
      this.v.setEnabled(false);
    if (t())
      this.w.setEnabled(true);
    else
      this.w.setEnabled(false);
  }

  void e()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 64);
    localMenuItem1.setText(c("FileMenu"));
    localMenuItem1.setMenu(a());
    MenuItem localMenuItem2 = new MenuItem(localMenu, 64);
    localMenuItem2.setText(c("EditMenu"));
    localMenuItem2.setMenu(b());
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(c("title.ClassInfoEditor"));
    this.a.setLayout(h.a(1));
    this.a.addShellListener(new f(this));
  }

  private void b(Composite paramComposite)
  {
    SashForm localSashForm = new SashForm(paramComposite, 256);
    localSashForm.setLayout(new FillLayout());
    c(localSashForm);
    d(localSashForm);
    localSashForm.setWeights(new int[] { 20, 80 });
  }

  private void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(localComposite, 8389504);
    localCTabFolder.setLayoutData(new GridData(1808));
    CTabItem localCTabItem = new CTabItem(localCTabFolder, 0);
    localCTabItem.setText(c("classes.ClassInfoEditor"));
    this.y = new com.flagleader.builder.widget.s().a(localCTabFolder, 2818);
    this.y.setLayoutData(new GridData(1808));
    this.y.setHeaderVisible(false);
    this.y.addMouseListener(new g(this));
    s();
    this.j = new TreeEditor(this.y);
    localCTabItem.setControl(this.y);
  }

  public TreeItem f()
  {
    if ((this.y != null) && (this.y.getSelection() != null) && (this.y.getSelection().length == 1))
      return this.y.getSelection()[0];
    return null;
  }

  private void d(Composite paramComposite)
  {
    this.m = new Composite(paramComposite, 2048);
    this.m.setBackground(h.d);
    this.m.setLayout(h.a(1));
    this.m.setLayoutData(new GridData(1808));
    this.r = new CTabFolder(this.m, 8389504);
    this.r.setLayoutData(new GridData(1808));
    this.h = new CTabItem(this.r, 0);
    this.h.setText(c("methods.ClassInfoEditor"));
    this.s = new CTabItem(this.r, 0);
    this.s.setText(c("code.ClassInfoEditor"));
    this.r.setSelection(this.h);
    this.r.addSelectionListener(new m(this));
  }

  private void l()
  {
    Composite localComposite1 = new Composite(this.a, 0);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    this.p = new SashForm(localComposite1, 512);
    this.p.setLayout(h.a(1));
    this.p.setLayoutData(new GridData(1808));
    b(this.p);
    this.n = new Composite(this.p, 2048);
    this.n.setBackground(h.d);
    this.n.setLayout(h.a(1));
    this.n.setLayoutData(new GridData(1808));
    Composite localComposite2 = new Composite(this.n, 0);
    localComposite2.setLayout(h.a(1));
    localComposite2.setLayoutData(new GridData(1808));
    this.d = com.flagleader.builder.widget.editor.s.a(0, null, localComposite2, 2882);
    this.k = this.d.a();
    this.k.setLayoutData(new GridData(1808));
    this.k.addMouseMoveListener(new n(this));
    this.k.addMouseListener(new o(this));
    this.p.setWeights(new int[] { 90, 10 });
    d();
  }

  private Composite a(CTabFolder paramCTabFolder, InfoClass paramInfoClass)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.u = a(localComposite);
    Iterator localIterator = paramInfoClass.getChildrenIterator();
    while (localIterator.hasNext())
      a((InfoMember)localIterator.next());
    localComposite.setData(this.u);
    for (int i1 = 0; i1 < this.u.getColumnCount(); i1++)
      this.u.getColumn(i1).pack();
    return localComposite;
  }

  private boolean a(InfoMember paramInfoMember)
  {
    TableItem localTableItem = new TableItem(this.u, 0);
    localTableItem.setText(1, paramInfoMember.getMemberName());
    localTableItem.setText(2, paramInfoMember.getTypeName());
    localTableItem.setText(0, paramInfoMember.getDisplayName());
    localTableItem.setText(3, paramInfoMember.getParameterInfo());
    localTableItem.setData(paramInfoMember);
    if (!paramInfoMember.checkDisplay())
      localTableItem.setForeground(h.g);
    return true;
  }

  private Composite b(CTabFolder paramCTabFolder, InfoClass paramInfoClass)
  {
    this.b = new Composite(paramCTabFolder, 0);
    this.b.setLayout(h.a(1));
    this.b.setLayoutData(new GridData(1808));
    String str = "";
    if (com.flagleader.repository.lang.info.a.b().a().getResource(paramInfoClass.getClassName().replace('.', '/') + ".java") != null)
      try
      {
        str = FileUtil.readFromStream(com.flagleader.repository.lang.info.a.b().a().getResourceAsStream(paramInfoClass.getClassName().replace('.', '/') + ".java"));
      }
      catch (Exception localException)
      {
      }
    this.c = com.flagleader.builder.widget.editor.s.a(1, null, this.b, 2818, new p(this, str));
    this.l = this.c.a();
    this.l.setLayoutData(new GridData(1808));
    this.l.setText(str);
    this.b.setData(this.c);
    this.c.b().a(false);
    return this.b;
  }

  void a(String paramString)
  {
    MessageDialog.openError(this.a, "", paramString);
  }

  public static void main(String[] paramArrayOfString)
  {
    ClassInfoEditor localClassInfoEditor = new ClassInfoEditor();
    Shell localShell = localClassInfoEditor.b(null);
    Display localDisplay = localShell.getDisplay();
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    e();
    c();
    l();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  private void m()
  {
    if (this.r.getItem(0).getData() != null)
    {
      InfoClass localInfoClass = (InfoClass)this.r.getItem(0).getData();
      if (com.flagleader.repository.lang.info.a.b().a().getResource(localInfoClass.getClassName().replace('.', '/') + ".java") != null)
        this.l.setText(FileUtil.readFromStream(com.flagleader.repository.lang.info.a.b().a().getResourceAsStream(localInfoClass.getClassName().replace('.', '/') + ".java")));
    }
  }

  private void a(InfoClass paramInfoClass)
  {
    this.a.getDisplay().asyncExec(new r(this, paramInfoClass));
  }

  private Class d(String paramString)
  {
    File localFile1 = new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + ".class");
    File localFile2 = new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + ".java");
    if ((localFile2.exists()) && ((!localFile1.exists()) || (localFile1.lastModified() < localFile2.lastModified())))
    {
      String str = new com.flagleader.repository.a.c().a(localFile2, Property.getInstance().getRuleEngineClassDir());
      if (str != null)
        throw new com.flagleader.repository.a.a(str);
      RuleClassLoader localRuleClassLoader = new RuleClassLoader(com.flagleader.repository.lang.info.a.b().a());
      return localRuleClassLoader.loadClassFromFile(localFile1);
    }
    return com.flagleader.repository.lang.info.a.b().a().loadClass(paramString);
  }

  private void n()
  {
    List localList = com.flagleader.repository.lang.info.a.b().c();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      InfoClass localInfoClass = (InfoClass)localList.get(i1);
      a(localInfoClass);
    }
  }

  private void o()
  {
    if (this.r.getItem(0).getData() != null)
    {
      InfoClass localInfoClass = (InfoClass)this.r.getItem(0).getData();
      a(localInfoClass);
    }
  }

  private void a(String paramString1, String paramString2)
  {
    this.k.setText(paramString2);
    Vector localVector = new Vector();
    Object localObject = new StringTokenizer(paramString2, "\n\r");
    while (((StringTokenizer)localObject).hasMoreTokens())
      localVector.addElement(((StringTokenizer)localObject).nextToken());
    localObject = new Vector();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "\n\r");
    while (localStringTokenizer.hasMoreTokens())
      ((Vector)localObject).addElement(localStringTokenizer.nextToken());
    this.q = new int[localVector.size()];
    for (int i1 = 0; i1 < this.q.length; i1++)
    {
      String str1 = localVector.get(i1).toString();
      if (str1.indexOf(".java:") > 0)
      {
        String str2 = str1.substring(str1.indexOf(".java:") + 6, str1.indexOf(":", str1.indexOf(".java:") + 6));
        try
        {
          this.q[i1] = this.l.getOffsetAtLine(Integer.parseInt(str2));
        }
        catch (Exception localException)
        {
          this.q[i1] = -1;
        }
      }
      else
      {
        this.q[i1] = -1;
      }
    }
  }

  void g()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.jcf" });
    String str = localFileDialog.open();
    if (str != null)
      b(str);
  }

  private void p()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.class" });
    String str = localFileDialog.open();
    if (str != null)
      b(str);
  }

  private void a(TreeItem paramTreeItem)
  {
    InfoClass localInfoClass = (InfoClass)paramTreeItem.getData();
    if (localInfoClass != null)
    {
      FileDialog localFileDialog = new FileDialog(this.a, 4096);
      File localFile1 = new File(Property.getInstance().getRuleEngineClassDir(), localInfoClass.getClassName().replace('.', File.separatorChar) + ".class");
      localFileDialog.setFilterPath(localFile1.getParent());
      localFileDialog.setFileName(localFile1.getName());
      localFileDialog.setFilterExtensions(new String[] { "*.class" });
      String str1 = localFileDialog.open();
      if (str1 != null)
        try
        {
          File localFile2 = new File(str1);
          Class localClass = new RuleClassLoader(q()).loadClassFromFile(null, localFile2);
          if (localClass == null)
            throw new ClassNotFoundException();
          String str2 = localClass.getName();
          String str3 = localFile2.getPath();
          if (!new File(Property.getInstance().getRuleEngineClassDir(), str2.replace('.', File.separatorChar) + ".class").exists())
            FileUtil.copy(localFile2, new File(Property.getInstance().getRuleEngineClassDir(), str2.replace('.', File.separatorChar) + ".class"), true);
          localInfoClass.updateClass(localClass);
          this.t.remove(localInfoClass);
          b(localInfoClass);
          d();
        }
        catch (Exception localException)
        {
          a(localException.getMessage(), Level.SEVERE);
        }
    }
  }

  private void b(TreeItem paramTreeItem)
  {
    InfoClass localInfoClass = (InfoClass)paramTreeItem.getData();
    if (localInfoClass != null)
    {
      this.j.horizontalAlignment = 16384;
      this.j.grabHorizontal = true;
      this.j.verticalAlignment = 16777224;
      this.j.grabVertical = true;
      this.j.minimumWidth = 60;
      if (this.A != null)
      {
        this.A.dispose();
        this.A = null;
      }
      this.A = new Text(this.y, 0);
      String str;
      if (paramTreeItem.getText().indexOf("(") > 0)
      {
        this.A.setText(paramTreeItem.getText().substring(0, paramTreeItem.getText().indexOf("(")));
        str = paramTreeItem.getText().substring(paramTreeItem.getText().indexOf("(") + 1, paramTreeItem.getText().length() - 1);
      }
      else
      {
        this.A.setText(paramTreeItem.getText());
        str = paramTreeItem.getText();
      }
      this.A.selectAll();
      this.j.setEditor(this.A, paramTreeItem);
      this.A.setFocus();
      this.A.addTraverseListener(new s(this, localInfoClass, paramTreeItem, str));
      this.A.addFocusListener(new t(this, localInfoClass, paramTreeItem, str));
    }
  }

  private void c(TreeItem paramTreeItem)
  {
    InfoClass localInfoClass = (InfoClass)paramTreeItem.getData();
    if (localInfoClass != null)
      if (MessageDialog.openQuestion(null, "", ResourceTools.formatMessage("infoclassdelete.question", new String[] { localInfoClass.getDisplayName() })))
      {
        localInfoClass.deleteFile();
        TreeItem localTreeItem = paramTreeItem.getParentItem();
        paramTreeItem.dispose();
        if ((localTreeItem != null) && (localTreeItem.getItemCount() == 0))
          localTreeItem.dispose();
        com.flagleader.repository.lang.info.a.b().a(localInfoClass);
      }
  }

  void h()
  {
    if ((this.r.getItemCount() > 0) && (this.r.getItem(0).getData() != null))
    {
      InfoClass localInfoClass = (InfoClass)this.r.getItem(0).getData();
      if ((((com.flagleader.builder.widget.editor.p)this.r.getItem(1).getControl().getData()).b().b()) && (new File(Property.getInstance().getRuleEngineClassDir()).exists()))
      {
        File localFile = new File(new File(Property.getInstance().getRuleEngineClassDir()), localInfoClass.getClassName().replace('.', '/') + ".java");
        try
        {
          FileUtil.saveToFile(localFile, new StringBuffer(this.l.getText()));
          ((com.flagleader.builder.widget.editor.p)this.r.getItem(1).getControl().getData()).b().a(false);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      if (localInfoClass.isModified())
        try
        {
          localInfoClass.save();
          localInfoClass.setModified(false);
        }
        catch (Exception localException1)
        {
          a(localException1.getMessage(), Level.SEVERE);
        }
      d();
    }
  }

  void i()
  {
    Iterator localIterator = com.flagleader.repository.lang.info.a.b().c().iterator();
    while (localIterator.hasNext())
    {
      InfoClass localInfoClass = (InfoClass)localIterator.next();
      try
      {
        localInfoClass.save();
      }
      catch (Exception localException)
      {
        a(localException.getMessage(), Level.SEVERE);
      }
    }
    d();
  }

  private ClassLoader q()
  {
    return com.flagleader.repository.lang.info.a.b().a();
  }

  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    Object localObject;
    if (!localFile.exists())
    {
      localObject = MessageFormat.format(c("Err_not_found"), new String[] { localFile.getName() });
      a((String)localObject);
      return;
    }
    try
    {
      localObject = new File(paramString);
      if (paramString.endsWith(".class"))
      {
        Class localClass = new RuleClassLoader(q()).loadClassFromFile(null, (File)localObject);
        if (localClass == null)
          throw new ClassNotFoundException();
        String str1 = localClass.getName();
        String str2 = ((File)localObject).getPath();
        if (!new File(Property.getInstance().getRuleEngineClassDir(), str1.replace('.', File.separatorChar) + ".class").exists())
          FileUtil.copy((File)localObject, new File(Property.getInstance().getRuleEngineClassDir(), str1.replace('.', File.separatorChar) + ".class"), true);
        b(com.flagleader.repository.lang.info.a.b().a(localClass));
      }
      else
      {
        b(com.flagleader.repository.lang.info.a.b().b(((File)localObject).getPath()));
      }
      s();
      d();
    }
    catch (Exception localException)
    {
      a(localException.getMessage(), Level.SEVERE);
    }
  }

  private void b(InfoClass paramInfoClass)
  {
    if (paramInfoClass == null)
      return;
    if ((this.r.getItemCount() > 0) && (paramInfoClass.equals(this.r.getItem(0).getData())))
      return;
    do
      this.r.getItem(0).dispose();
    while (this.r.getItemCount() > 0);
    Composite localComposite = (Composite)this.t.get(paramInfoClass);
    this.h = new CTabItem(this.r, 0);
    this.h.setText(c("methods.ClassInfoEditor"));
    if ((localComposite != null) && ((localComposite.getData() instanceof Table)))
    {
      this.h.setControl(localComposite);
      this.u = ((Table)localComposite.getData());
    }
    else
    {
      localComposite = a(this.r, paramInfoClass);
      this.h.setControl(localComposite);
      this.t.put(paramInfoClass, localComposite);
    }
    this.h.setData(paramInfoClass);
    this.s = new CTabItem(this.r, 0);
    this.s.setText(c("code.ClassInfoEditor"));
    this.s.setControl(b(this.r, paramInfoClass));
    this.r.setSelection(this.h);
  }

  private void c(InfoClass paramInfoClass)
  {
    Composite localComposite = (Composite)this.t.get(paramInfoClass);
    if (localComposite != null)
    {
      Table localTable = (Table)localComposite.getData();
      localTable.removeAll();
      Iterator localIterator = paramInfoClass.getChildrenIterator();
      while (localIterator.hasNext())
        a((InfoMember)localIterator.next());
    }
  }

  private void r()
  {
    this.a.close();
  }

  private void s()
  {
    this.y.removeAll();
    List localList = com.flagleader.repository.lang.info.a.b().c();
    for (int i1 = 0; i1 < localList.size(); i1++)
      d((InfoClass)localList.get(i1));
  }

  private void d(InfoClass paramInfoClass)
  {
    String str1 = paramInfoClass.getClassName();
    String str2 = "";
    if (str1.lastIndexOf(".") > 0)
    {
      str2 = str1.substring(0, str1.lastIndexOf("."));
      str1 = str1.substring(str1.lastIndexOf(".") + 1);
    }
    if (str2.length() > 0)
    {
      localObject = this.y.getItems();
      for (int i1 = 0; i1 < localObject.length; i1++)
      {
        if ((localObject[i1].getData() != null) || (!localObject[i1].getText().equals(str2)))
          continue;
        localTreeItem2 = new TreeItem(localObject[i1], 0);
        localTreeItem2.setImage(ResourceTools.getImage("jcuobj.icon"));
        if (paramInfoClass.getDisplayName().length() > 0)
          localTreeItem2.setText(paramInfoClass.getDisplayName() + "(" + str1 + ")");
        else
          localTreeItem2.setText(str1);
        localTreeItem2.setData(paramInfoClass);
        localObject[i1].setExpanded(true);
        return;
      }
      TreeItem localTreeItem1 = new TreeItem(this.y, 0);
      localTreeItem1.setImage(ResourceTools.getImage("packageobj.icon"));
      localTreeItem1.setText(str2);
      TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
      localTreeItem2.setImage(ResourceTools.getImage("jcuobj.icon"));
      if (paramInfoClass.getDisplayName().length() > 0)
        localTreeItem2.setText(paramInfoClass.getDisplayName() + "(" + str1 + ")");
      else
        localTreeItem2.setText(str1);
      localTreeItem2.setData(paramInfoClass);
      localTreeItem1.setExpanded(true);
      return;
    }
    Object localObject = new TreeItem(this.y, 0);
    ((TreeItem)localObject).setImage(ResourceTools.getImage("jcuobj.icon"));
    if (paramInfoClass.getDisplayName().length() > 0)
      ((TreeItem)localObject).setText(paramInfoClass.getDisplayName() + "(" + str1 + ")");
    else
      ((TreeItem)localObject).setText(str1);
    ((TreeItem)localObject).setData(paramInfoClass);
  }

  private void a(String paramString, Level paramLevel)
  {
    if (!this.k.isDisposed())
      this.k.append(paramString + "\n");
    this.k.setSelection(this.k.getText().length());
  }

  private boolean t()
  {
    Iterator localIterator = com.flagleader.repository.lang.info.a.b().c().iterator();
    while (localIterator.hasNext())
    {
      InfoClass localInfoClass = (InfoClass)localIterator.next();
      if (localInfoClass.isModified())
        return true;
    }
    return false;
  }

  public Table a(Composite paramComposite)
  {
    i locali = new i(false, true);
    this.u = locali.a(paramComposite, 66306);
    String[] arrayOfString1 = j();
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ClassInfoEditor");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ClassInfoEditor");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    locali.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.u.setLayoutData(new GridData(1808));
    this.u.setHeaderVisible(true);
    this.u.setLinesVisible(true);
    TableEditor localTableEditor = new TableEditor(this.u);
    this.u.addMouseListener(new u(this, localTableEditor));
    return this.u;
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new w(this, paramTableItem, paramText, paramInt, paramTableEditor));
    paramText.addTraverseListener(new x(this, paramTableItem, paramText, paramInt, paramTableEditor));
  }

  private void a(TableItem paramTableItem, Text paramText, int paramInt, TableEditor paramTableEditor)
  {
    paramTableItem.setText(paramInt, paramText.getText());
    InfoMember localInfoMember = (InfoMember)paramTableItem.getData();
    if ((paramInt == 0) && (!localInfoMember.getDisplayName().equals(paramTableItem.getText(0))))
    {
      localInfoMember.setDisplayName(paramTableItem.getText(0));
      localInfoMember.getInfoClass().setModified(true);
    }
    a(paramText, paramTableEditor);
  }

  private void a(Text paramText, TableEditor paramTableEditor)
  {
    paramTableEditor.setEditor(null, null, -1);
    if ((paramText != null) && (!paramText.isDisposed()))
      paramText.dispose();
    paramTableEditor.setItem(null);
  }

  protected String[] j()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.ClassInfoEditor");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString[i1] + ".ClassInfoEditor") == null)
        continue;
      arrayOfString[i1] = ResourceTools.getMessage(arrayOfString[i1] + ".ClassInfoEditor");
    }
    return arrayOfString;
  }

  private void u()
  {
    if ((this.u.getSelection().length > 0) && ((this.u.getSelection()[0].getData() instanceof InfoMethod)))
    {
      TableItem localTableItem = this.u.getSelection()[0];
      InfoMethod localInfoMethod = (InfoMethod)localTableItem.getData();
      F localF = new F(this, localInfoMethod);
      if (localF.open() == 0)
        localTableItem.setText(3, localInfoMethod.getParameterInfo());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ClassInfoEditor
 * JD-Core Version:    0.6.0
 */