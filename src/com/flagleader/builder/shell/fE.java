package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.br;
import com.flagleader.builder.dialogs.q;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.database.SQLType;
import com.flagleader.database.TypeMap;
import com.flagleader.repository.d.I;
import com.flagleader.repository.db.DBModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.StringTokenizer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class fE
  implements br
{
  Shell a;
  StyledText b;
  private p g;
  private TableEditor h;
  FileDialog c;
  private Text i;
  ToolBar d;
  Menu e;
  private int j = 1;
  Statement f = null;
  private boolean k = false;
  private i l;
  private Table m;
  private DBModel n;
  private Connection o;
  private Composite p;
  private Composite q;
  private StyledText r;
  private int s = 0;
  private SashForm t;
  private CTabFolder u;
  private CTabItem v;
  private CTabItem w;
  private StringBuffer x = new StringBuffer();

  public fE(DBModel paramDBModel)
  {
    this.n = paramDBModel;
    try
    {
      this.o = paramDBModel.getConnection();
    }
    catch (Exception localException)
    {
      this.o = null;
    }
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new fF(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new fR(this));
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
    localMenuItem.addSelectionListener(new fV(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("RedoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new fW(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CutItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new fX(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("CopyItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem.addSelectionListener(new fY(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("PasteItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    localMenuItem.addSelectionListener(new fZ(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("RunItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new ga(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(c("exportxls.popup"));
    localMenuItem.setAccelerator(16777233);
    localMenuItem.addSelectionListener(new gb(this));
    return localMenu2;
  }

  void c()
  {
    this.d = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("OpenItem.icon"));
    localToolItem.addSelectionListener(new fG(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("cut.icon"));
    localToolItem.addSelectionListener(new fH(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("copy.icon"));
    localToolItem.addSelectionListener(new fI(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("paste.icon"));
    localToolItem.addSelectionListener(new fJ(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("TestItem.icon"));
    localToolItem.addSelectionListener(new fK(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("exportxls.icon"));
    localToolItem.addSelectionListener(new fL(this));
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
    this.a.setText(c("Sql_title"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new fM(this));
  }

  private void j()
  {
    Composite localComposite = new Composite(this.a, 0);
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
    CTabItem localCTabItem = new CTabItem(localCTabFolder, 0);
    localCTabItem.setText(c("sql_text"));
    a(localCTabFolder);
    localCTabItem.setControl(this.b);
    localCTabFolder.setSelection(localCTabItem);
    this.q = new Composite(this.t, 2048);
    this.q.setBackground(h.d);
    this.q.setLayout(h.a(1));
    this.q.setLayoutData(new GridData(1808));
    this.u = new CTabFolder(this.q, 8389504);
    this.u.setLayoutData(new GridData(1808));
    this.v = new CTabItem(this.u, 0);
    this.v.setText(c("sql_result"));
    this.v.setControl(l());
    this.w = new CTabItem(this.u, 0);
    this.w.setText(c("sql_result_data"));
    this.w.setControl(e());
    this.u.setSelection(this.v);
    this.t.setWeights(new int[] { 20, 80 });
  }

  void a(Composite paramComposite)
  {
    this.g = s.a(4, new fN(this), paramComposite, 2818, new fO(this, ""));
    this.b = this.g.a();
    this.b.setLayoutData(new GridData(1808));
  }

  private void k()
  {
  }

  private Composite l()
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
    this.l = new i(true, true);
    this.m = this.l.a(localComposite, 66304);
    this.m.setLayoutData(new GridData(1808));
    this.m.setHeaderVisible(true);
    this.m.setLinesVisible(true);
    this.m.addMouseListener(new fP(this));
    return localComposite;
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  public static void a(DBModel paramDBModel)
  {
    fE localfE = new fE(paramDBModel);
    Shell localShell = localfE.b(null);
    localShell.addDisposeListener(new fS(localfE));
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
    d();
    c();
    j();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  public void f()
  {
    try
    {
      if ((this.o != null) && (!this.o.isClosed()))
      {
        this.o.close();
        this.o = null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void m()
  {
    String str = this.b.getText();
    if ((this.b.getSelectionText() != null) && (this.b.getSelectionText().length() > 0))
      str = this.b.getSelectionText();
    if (str.length() > 0)
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str, ";");
      String[] arrayOfString = new String[localStringTokenizer.countTokens()];
      int i1 = 0;
      while (localStringTokenizer.hasMoreTokens())
        arrayOfString[(i1++)] = localStringTokenizer.nextToken();
      try
      {
        if ((this.o == null) || (this.o.isClosed()))
          this.o = this.n.getConnection();
      }
      catch (Exception localException1)
      {
        d("result: " + localException1.getLocalizedMessage());
        this.u.setSelection(this.v);
        return;
      }
      try
      {
        this.f = this.o.createStatement();
        for (i1 = 0; i1 < arrayOfString.length; i1++)
        {
          d("sql: " + arrayOfString[i1]);
          if (this.f.execute(arrayOfString[i1]))
            d("reselt: true");
          else
            d("result: " + String.valueOf(this.f.getUpdateCount()));
        }
        ResultSet localResultSet = this.f.getResultSet();
        if (localResultSet != null)
        {
          a(localResultSet);
          this.k = false;
          q localq = new q(this);
          localq.setBlockOnOpen(false);
          localq.open();
          fT localfT = new fT(this, localResultSet, localq);
          Display.getCurrent().timerExec(0, localfT);
          this.u.setSelection(this.w);
        }
        else
        {
          this.u.setSelection(this.v);
        }
        if (!this.o.getAutoCommit())
          this.o.commit();
      }
      catch (Exception localException2)
      {
        d("result: " + localException2.getLocalizedMessage());
        this.u.setSelection(this.v);
      }
    }
  }

  private void d(String paramString)
  {
    this.x.append(paramString + "\n");
    this.r.setText(this.x.toString());
    this.r.setSelection(this.r.getText().length());
  }

  public void a(ResultSet paramResultSet)
  {
    while (this.m.getColumnCount() > 0)
      this.m.getColumn(0).dispose();
    ResultSetMetaData localResultSetMetaData = paramResultSet.getMetaData();
    this.s = localResultSetMetaData.getColumnCount();
    this.j = 1;
    this.m.removeAll();
    Control[] arrayOfControl = this.m.getChildren();
    for (int i1 = 0; i1 < arrayOfControl.length; i1++)
      arrayOfControl[i1].dispose();
    String[] arrayOfString1 = new String[this.s + 1];
    String[] arrayOfString2 = new String[this.s + 1];
    int[] arrayOfInt = new int[this.s + 1];
    arrayOfString1[0] = "";
    arrayOfString2[0] = "int";
    arrayOfInt[0] = 30;
    for (int i2 = 1; i2 <= this.s; i2++)
    {
      arrayOfString1[i2] = localResultSetMetaData.getColumnLabel(i2);
      arrayOfString2[i2] = TypeMap.getDefault().getJavaType(new SQLType(localResultSetMetaData.getColumnTypeName(i2), localResultSetMetaData.getColumnType(i2)));
      arrayOfInt[i2] = 80;
    }
    this.l.a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  private boolean b(ResultSet paramResultSet)
  {
    if ((this.k) || (paramResultSet == null) || (!paramResultSet.next()))
    {
      this.k = true;
      for (int i1 = 1; i1 < this.m.getColumnCount(); i1++)
        this.m.getColumns()[i1].pack();
      return true;
    }
    TableItem localTableItem = new TableItem(this.m, 0);
    localTableItem.setText(0, String.valueOf(this.j++));
    for (int i2 = 0; i2 < this.s; i2++)
    {
      String str = a(paramResultSet.getObject(i2 + 1));
      if (str.length() > 30)
      {
        localTableItem.setData(String.valueOf(i2 + 1), str);
        localTableItem.setText(i2 + 1, str.substring(0, 30) + "...");
      }
      else
      {
        localTableItem.setText(i2 + 1, str);
      }
    }
    this.m.update();
    return false;
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  void g()
  {
    if (this.c == null)
      this.c = new FileDialog(this.a, 4096);
    this.c.setFilterExtensions(new String[] { "*.sql", "*.*" });
    String str = this.c.open();
    b(str);
  }

  void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    Object localObject1;
    if (!localFile.exists())
    {
      localObject1 = MessageFormat.format(c("Err_file_no_exist"), new String[] { localFile.getName() });
      a((String)localObject1);
      return;
    }
    String str1;
    try
    {
      localObject1 = new FileInputStream(localFile.getPath());
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject1));
        localObject2 = new char[2048];
        StringBuffer localStringBuffer = new StringBuffer((int)localFile.length());
        int i1;
        while ((i1 = localBufferedReader.read(localObject2)) > 0)
          localStringBuffer.append(localObject2, 0, i1);
        str1 = localStringBuffer.toString();
        ((FileInputStream)localObject1).close();
      }
      catch (IOException localIOException)
      {
        Object localObject2 = MessageFormat.format(c("Err_file_io"), new String[] { localFile.getName() });
        a((String)localObject2);
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      String str2 = MessageFormat.format(c("Err_not_found"), new String[] { localFile.getName() });
      a(str2);
      return;
    }
    Display localDisplay = this.b.getDisplay();
    localDisplay.asyncExec(new fU(this, str1));
  }

  void h()
  {
    this.a.close();
  }

  public boolean i()
  {
    return this.k;
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fE
 * JD-Core Version:    0.6.0
 */