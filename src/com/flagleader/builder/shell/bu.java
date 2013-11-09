package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.a.X;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.a.k;
import com.flagleader.builder.widget.a.t;
import com.flagleader.builder.widget.a.v;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.export.RspTags;
import com.flagleader.repository.export.Tag;
import com.flagleader.repository.export.d;
import com.flagleader.repository.export.f;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class bu
{
  Shell a;
  StyledText b;
  StyledText c;
  StyledText d;
  af e;
  af f;
  af g;
  String h;
  private RspTags k = RspTags.getInstance();
  ToolBar i;
  private Composite l;
  private Composite m;
  private StyledText n;
  private int o = 0;
  private SashForm p;
  private int[] q;
  private CTabFolder r;
  private CTabItem s;
  t j = null;
  private String t = "";

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new bv(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("SaveItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new bG(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("SaveasItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new bO(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("saveModelItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 77);
    localMenuItem.addSelectionListener(new bP(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("setTagsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 84);
    localMenuItem.addSelectionListener(new bQ(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new bR(this));
    return localMenu2;
  }

  private String c(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  Menu b()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("UndoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new bS(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("RedoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new bT(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CutItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new bU(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CopyItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem.addSelectionListener(new bw(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("PasteItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    localMenuItem.addSelectionListener(new bx(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("SelectAllItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    localMenuItem.addSelectionListener(new by(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CompileItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new bz(this));
    return localMenu2;
  }

  void c()
  {
    this.i = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("OpenItem.icon"));
    localToolItem.addSelectionListener(new bA(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("SaveItem.icon"));
    localToolItem.addSelectionListener(new bB(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("undo.icon"));
    localToolItem.addSelectionListener(new bC(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("redo.icon"));
    localToolItem.addSelectionListener(new bD(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("cut.icon"));
    localToolItem.addSelectionListener(new bE(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("copy.icon"));
    localToolItem.addSelectionListener(new bF(this));
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("paste.icon"));
    localToolItem.addSelectionListener(new bH(this));
    localToolItem = new ToolItem(this.i, 2);
    localToolItem = new ToolItem(this.i, 8);
    localToolItem.setImage(ResourceTools.getImage("exportcompile.icon"));
    localToolItem.addSelectionListener(new bI(this));
  }

  void d()
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
    this.a.setText(c("title.RspHtmlEditor"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new bJ(this));
  }

  private void l()
  {
    Composite localComposite1 = new Composite(this.a, 0);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    this.p = new SashForm(localComposite1, 512);
    this.p.setLayout(h.a(1));
    this.p.setLayoutData(new GridData(1808));
    this.l = new Composite(this.p, 2048);
    this.l.setBackground(h.d);
    this.l.setLayout(h.a(1));
    this.l.setLayoutData(new GridData(1808));
    this.r = new CTabFolder(this.l, 8389504);
    this.r.setLayoutData(new GridData(1808));
    CTabItem localCTabItem1 = new CTabItem(this.r, 0);
    localCTabItem1.setText(c("html.RspHtmlEditor"));
    localCTabItem1.setControl(a(this.r));
    CTabItem localCTabItem2 = new CTabItem(this.r, 0);
    localCTabItem2.setText(c("model.RspHtmlEditor"));
    localCTabItem2.setControl(b(this.r));
    this.s = new CTabItem(this.r, 0);
    this.s.setText(c("code.RspHtmlEditor"));
    this.s.setControl(c(this.r));
    this.r.setSelection(localCTabItem1);
    this.r.addSelectionListener(new bK(this));
    this.m = new Composite(this.p, 2048);
    this.m.setBackground(h.d);
    this.m.setLayout(h.a(1));
    this.m.setLayoutData(new GridData(1808));
    Composite localComposite2 = new Composite(this.m, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    this.n = new af(localComposite2, 2882).m();
    this.n.setLayoutData(new GridData(1808));
    this.n.addMouseMoveListener(new bL(this));
    this.n.addMouseListener(new bM(this));
    this.p.setWeights(new int[] { 80, 20 });
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.g = new k(localComposite, 2818, j());
    this.b = this.g.m();
    return localComposite;
  }

  private Composite b(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.c = new X(localComposite, 2818).m();
    this.c.setEditable(false);
    return localComposite;
  }

  private Composite c(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.d = new v(localComposite, 2818).m();
    this.d.setLayoutData(new GridData(1808));
    this.d.setText("");
    this.d.setEditable(false);
    return localComposite;
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    d();
    c();
    l();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  private void m()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.b.getText());
    a(localStringBuffer);
    this.c.setText(localStringBuffer.toString());
  }

  private void n()
  {
    f localf = new f();
    try
    {
      localf.c(this.c.getText());
      this.d.setText(localf.k());
      if (this.j != null)
        this.j.a(this.d.getText());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void a(StringBuffer paramStringBuffer)
  {
    int i1 = paramStringBuffer.indexOf("<rsp:");
    int i2;
    if (i1 >= 0)
    {
      i2 = paramStringBuffer.indexOf(">", i1);
      if (i2 > i1)
      {
        a(paramStringBuffer, i1, i2);
        a(paramStringBuffer);
      }
    }
    i1 = paramStringBuffer.indexOf("</rsp:");
    if (i1 > 0)
    {
      i2 = paramStringBuffer.indexOf(">", i1);
      if (i2 > i1)
      {
        String str = paramStringBuffer.substring(i1 + 6, i2);
        Tag localTag = j().getTag(str.trim());
        if (localTag != null)
        {
          StringBuffer localStringBuffer = new StringBuffer(localTag.getPostCode());
          paramStringBuffer.replace(i1, i2 + 1, localStringBuffer.toString());
        }
      }
      a(paramStringBuffer);
    }
  }

  private void a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    String str1 = paramStringBuffer.substring(paramInt1, paramInt2 + 1);
    int i1 = str1.indexOf(" ");
    if (i1 < 0)
      i1 = str1.indexOf("/>");
    if (i1 < 0)
      i1 = str1.indexOf(">");
    if (i1 > 5)
    {
      String str2 = str1.substring(5, i1);
      Tag localTag = j().getTag(str2.trim());
      if (localTag != null)
      {
        StringBuffer localStringBuffer = new StringBuffer(localTag.getPreCode());
        while (localStringBuffer.indexOf("$") >= 0)
        {
          int i2 = localStringBuffer.indexOf("$");
          int i3 = localStringBuffer.indexOf("$", i2 + 1);
          if (i3 <= i2)
            continue;
          localStringBuffer.replace(i2, i3 + 1, a(str1, localStringBuffer.substring(i2 + 1, i3)));
        }
        paramStringBuffer.replace(paramInt1, paramInt2 + 1, localStringBuffer.toString());
        return;
      }
    }
    paramStringBuffer.replace(paramInt1, paramInt2 + 1, "");
  }

  private String a(String paramString1, String paramString2)
  {
    int i1 = paramString1.indexOf(paramString2 + "=");
    if (i1 < 0)
      return "";
    int i2 = paramString1.indexOf(" ", i1);
    if (i2 < 0)
      i2 = paramString1.indexOf("/>", i1);
    if (i2 < 0)
      i2 = paramString1.indexOf(">", i1);
    if (i2 > i1)
    {
      String str = paramString1.substring(i1 + paramString2.length() + 1, i2);
      if ((str.startsWith("\"")) && (str.endsWith("\"")))
        return str.substring(1, str.length() - 1);
      return str;
    }
    return "";
  }

  private void o()
  {
    bW localbW = new bW(this);
    localbW.setLevel(Level.ALL);
    Logger localLogger = Logger.getLogger("flagleader");
    localLogger.addHandler(localbW);
    Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getActiveShell().getDisplay().getSystemCursor(1));
    m();
    f localf = new f();
    try
    {
      localf.c(this.c.getText());
      this.d.setText(localf.k());
      this.r.setSelection(this.s);
      this.n.setText("no error!");
    }
    catch (Exception localException)
    {
      b(localf.k(), localException.getLocalizedMessage());
    }
    finally
    {
      localLogger.removeHandler(localbW);
    }
    Display.getCurrent().getActiveShell().setCursor(null);
  }

  private void b(String paramString1, String paramString2)
  {
    this.n.setText(paramString2);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringTokenizer(paramString2, "\n\r");
    while (((StringTokenizer)localObject).hasMoreTokens())
      localArrayList.add(((StringTokenizer)localObject).nextToken());
    localObject = new ArrayList();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "\n\r");
    while (localStringTokenizer.hasMoreTokens())
      ((ArrayList)localObject).add(localStringTokenizer.nextToken());
    int i1 = 0;
    while (((ArrayList)localObject).get(i1++).toString().indexOf("protected void export() {") < 0);
    this.q = new int[localArrayList.size()];
    for (int i2 = 0; i2 < this.q.length; i2++)
    {
      String str1 = localArrayList.get(i2).toString();
      if (str1.indexOf(".java:") > 0)
      {
        String str2 = str1.substring(str1.indexOf(".java:") + 6, str1.indexOf(":", str1.indexOf(".java:") + 6));
        try
        {
          this.q[i2] = this.c.getOffsetAtLine(Integer.parseInt(str2) - i1 - 1);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          this.q[i2] = -1;
        }
      }
      else
      {
        this.q[i2] = -1;
      }
    }
  }

  void e()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.*" });
    String str = localFileDialog.open();
    if (str != null)
    {
      this.h = str;
      b(str);
    }
  }

  void f()
  {
    if (this.h == null)
    {
      FileDialog localFileDialog = new FileDialog(this.a, 8192);
      localFileDialog.setFilterExtensions(new String[] { "*.*" });
      this.h = localFileDialog.open();
    }
    try
    {
      if (this.h != null)
      {
        FileUtil.saveToFile(this.h, new StringBuffer(this.b.getText()));
        this.t = this.b.getText();
      }
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(c("Err_file_io"), new String[] { this.h });
      a(str);
      return;
    }
  }

  void g()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.*" });
    this.h = localFileDialog.open();
    try
    {
      if (this.h != null)
      {
        FileUtil.saveToFile(this.h, new StringBuffer(this.b.getText()));
        this.t = this.b.getText();
      }
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(c("Err_file_io"), new String[] { this.h });
      a(str);
      return;
    }
  }

  void h()
  {
    FileDialog localFileDialog = new FileDialog(this.a, 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.rsp" });
    String str1 = localFileDialog.open();
    try
    {
      if (str1 != null)
        FileUtil.saveToFile(str1, new StringBuffer(this.c.getText()));
    }
    catch (IOException localIOException)
    {
      String str2 = MessageFormat.format(c("Err_file_io"), new String[] { this.h });
      a(str2);
      return;
    }
  }

  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      String str2 = MessageFormat.format(c("Err_file_no_exist"), new String[] { localFile.getName() });
      a(str2);
      return;
    }
    String str1;
    try
    {
      str1 = FileUtil.readFromFile(localFile);
    }
    catch (IOException localIOException)
    {
      String str3 = MessageFormat.format(c("Err_file_io"), new String[] { localFile.getName() });
      a(str3);
      return;
    }
    this.t = this.b.getText();
    Display localDisplay = this.b.getDisplay();
    localDisplay.asyncExec(new bN(this, str1));
  }

  void i()
  {
    this.a.close();
  }

  private void a(String paramString, Level paramLevel)
  {
    if (!this.n.isDisposed())
      this.n.append(paramString + "\n");
  }

  public RspTags j()
  {
    if (this.k == null)
      this.k = RspTags.getInstance();
    return this.k;
  }

  public boolean k()
  {
    return !this.t.equals(this.b.getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bu
 * JD-Core Version:    0.6.0
 */