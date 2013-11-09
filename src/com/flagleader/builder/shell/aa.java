package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.d.I;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.MethodInfos;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.lang.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class aa
{
  Shell a;
  FileDialog b;
  private Text e;
  ToolBar c;
  Menu d;
  private Table f;
  private MethodInfos g;
  private d h;
  private Table i;
  private CTabFolder j;
  private CTabItem k;
  private CTabItem l;

  public aa(d paramd)
  {
    this.h = paramd;
    this.g = paramd.b();
  }

  private String b(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  private void h()
  {
    Object localObject1;
    Object localObject2;
    TableItem localTableItem;
    if (this.j.getSelectionIndex() == 1)
    {
      localObject1 = new ar(this);
      if ((((ar)localObject1).open() == 0) && (((ar)localObject1).b().length() > 0))
      {
        localObject2 = new TypeMethod();
        ((TypeMethod)localObject2).setFuncName(((ar)localObject1).b());
        ((TypeMethod)localObject2).setReturnType(((ar)localObject1).e());
        ((TypeMethod)localObject2).setDisName(((ar)localObject1).a());
        ((TypeMethod)localObject2).setTypeName(((ar)localObject1).c());
        ((TypeMethod)localObject2).setFuncBody(((ar)localObject1).d());
        this.g.addTypeMethod((TypeMethod)localObject2);
        localTableItem = new TableItem(this.f, 0);
        localTableItem.setText(0, ((TypeMethod)localObject2).getFuncName());
        localTableItem.setText(1, ((TypeMethod)localObject2).getDisName());
        localTableItem.setText(2, ((TypeMethod)localObject2).getReturnType());
        localTableItem.setText(3, ((TypeMethod)localObject2).getTypeName());
        localTableItem.setText(4, ((TypeMethod)localObject2).getFuncBody());
        localTableItem.setData(localObject2);
      }
    }
    else
    {
      localObject1 = new aq(this);
      if ((((aq)localObject1).open() == 0) && (((aq)localObject1).b().length() > 0))
      {
        localObject2 = new GlobalMethod();
        ((GlobalMethod)localObject2).setFuncName(((aq)localObject1).b());
        ((GlobalMethod)localObject2).setReturnType(((aq)localObject1).e());
        ((GlobalMethod)localObject2).setDisName(((aq)localObject1).a());
        ((GlobalMethod)localObject2).setTypeName(((aq)localObject1).c());
        ((GlobalMethod)localObject2).setFuncBody(((aq)localObject1).d());
        this.g.addGlobalMethod((GlobalMethod)localObject2);
        localTableItem = new TableItem(this.i, 0);
        localTableItem.setText(0, ((GlobalMethod)localObject2).getFuncName());
        localTableItem.setText(1, ((GlobalMethod)localObject2).getDisName());
        localTableItem.setText(2, ((GlobalMethod)localObject2).getReturnType());
        localTableItem.setText(3, ((GlobalMethod)localObject2).getTypeName());
        localTableItem.setText(4, ((GlobalMethod)localObject2).getFuncBody());
        localTableItem.setData(localObject2);
      }
    }
  }

  private void i()
  {
    TableItem localTableItem;
    Object localObject1;
    Object localObject2;
    if (this.j.getSelectionIndex() == 1)
    {
      if ((this.f.getSelection().length > 0) && ((this.f.getSelection()[0].getData() instanceof TypeMethod)))
      {
        localTableItem = this.f.getSelection()[0];
        localObject1 = (TypeMethod)localTableItem.getData();
        localObject2 = new ar(this, (TypeMethod)localObject1);
        if ((((ar)localObject2).open() == 0) && (((ar)localObject2).b().length() > 0))
        {
          ((TypeMethod)localObject1).setFuncName(((ar)localObject2).b());
          ((TypeMethod)localObject1).setReturnType(((ar)localObject2).e());
          ((TypeMethod)localObject1).setDisName(((ar)localObject2).a());
          ((TypeMethod)localObject1).setTypeName(((ar)localObject2).c());
          ((TypeMethod)localObject1).setFuncBody(((ar)localObject2).d());
          localTableItem.setText(0, ((TypeMethod)localObject1).getFuncName());
          localTableItem.setText(1, ((TypeMethod)localObject1).getDisName());
          localTableItem.setText(2, ((TypeMethod)localObject1).getReturnType());
          localTableItem.setText(3, ((TypeMethod)localObject1).getTypeName());
          localTableItem.setText(4, ((TypeMethod)localObject1).getFuncBody());
          localTableItem.setData(localObject1);
        }
      }
    }
    else if ((this.i.getSelection().length > 0) && ((this.i.getSelection()[0].getData() instanceof GlobalMethod)))
    {
      localTableItem = this.i.getSelection()[0];
      localObject1 = (GlobalMethod)localTableItem.getData();
      localObject2 = new aq(this, (GlobalMethod)localObject1);
      if ((((aq)localObject2).open() == 0) && (((aq)localObject2).b().length() > 0))
      {
        ((GlobalMethod)localObject1).setFuncName(((aq)localObject2).b());
        ((GlobalMethod)localObject1).setReturnType(((aq)localObject2).e());
        ((GlobalMethod)localObject1).setDisName(((aq)localObject2).a());
        ((GlobalMethod)localObject1).setTypeName(((aq)localObject2).c());
        ((GlobalMethod)localObject1).setFuncBody(((aq)localObject2).d());
        localTableItem.setText(0, ((GlobalMethod)localObject1).getFuncName());
        localTableItem.setText(1, ((GlobalMethod)localObject1).getDisName());
        localTableItem.setText(2, ((GlobalMethod)localObject1).getReturnType());
        localTableItem.setText(3, ((GlobalMethod)localObject1).getTypeName());
        localTableItem.setText(4, ((GlobalMethod)localObject1).getFuncBody());
        localTableItem.setData(localObject1);
      }
    }
  }

  private void j()
  {
    int m;
    TableItem localTableItem;
    Object localObject;
    if (this.j.getSelectionIndex() == 1)
    {
      if ((this.f.getSelection().length > 0) && ((this.f.getSelection()[0].getData() instanceof TypeMethod)))
        for (m = this.f.getSelection().length - 1; m >= 0; m--)
        {
          localTableItem = this.f.getSelection()[m];
          localObject = (TypeMethod)localTableItem.getData();
          this.g.romoveMethod((TypeMethod)localObject);
          localTableItem.dispose();
        }
    }
    else if ((this.i.getSelection().length > 0) && ((this.i.getSelection()[0].getData() instanceof GlobalMethod)))
      for (m = this.i.getSelection().length - 1; m >= 0; m--)
      {
        localTableItem = this.i.getSelection()[m];
        localObject = (GlobalMethod)localTableItem.getData();
        this.g.romoveMethod((GlobalMethod)localObject);
        localTableItem.dispose();
      }
  }

  private void k()
  {
  }

  private void l()
  {
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("AddItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    localMenuItem.addSelectionListener(new ab(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("edit.popup"));
    localMenuItem.setAccelerator(SWT.MOD1 + 69);
    localMenuItem.addSelectionListener(new ai(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("DeleteItem"));
    localMenuItem.addSelectionListener(new aj(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("SaveItem"));
    localMenuItem.setAccelerator(16777234);
    localMenuItem.addSelectionListener(new ak(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new al(this));
    return localMenu2;
  }

  void b()
  {
    this.c = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("SaveItem.icon"));
    localToolItem.addSelectionListener(new am(this));
    localToolItem = new ToolItem(this.c, 2);
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("add.icon"));
    localToolItem.addSelectionListener(new an(this));
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("PropertiesItem.icon"));
    localToolItem.addSelectionListener(new ao(this));
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("DeleteItem.icon"));
    localToolItem.addSelectionListener(new ap(this));
  }

  void c()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem = new MenuItem(localMenu, 64);
    localMenuItem.setText(b("EditMenu"));
    localMenuItem.setMenu(a());
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(b("title.MethodInfosEditor"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new ac(this));
  }

  private void m()
  {
    Composite localComposite1 = new Composite(this.a, 0);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    Composite localComposite2 = new Composite(localComposite1, 2048);
    localComposite2.setBackground(h.d);
    localComposite2.setLayout(h.a(1));
    localComposite2.setLayoutData(new GridData(1808));
    this.j = new CTabFolder(localComposite2, 8389504);
    this.j.setLayoutData(new GridData(1808));
    this.k = new CTabItem(this.j, 0);
    this.k.setText(b("global.MethodInfosEditor"));
    this.i = d();
    this.k.setControl(this.i);
    this.l = new CTabItem(this.j, 0);
    this.l.setText(b("type.MethodInfosEditor"));
    this.f = d();
    this.l.setControl(this.f);
    this.j.setSelection(this.k);
    List localList1 = this.g.getGlobalMethods();
    for (int m = 0; m < localList1.size(); m++)
      a((GlobalMethod)localList1.get(m));
    List localList2 = this.g.getTypeMethods();
    for (int n = 0; n < localList2.size(); n++)
      a((TypeMethod)localList2.get(n));
    for (n = 0; n < 5; n++)
    {
      this.i.getColumns()[n].pack();
      this.f.getColumns()[n].pack();
    }
  }

  public Table d()
  {
    i locali = new i(false, true);
    Table localTable = locali.a(this.j, 66304);
    String[] arrayOfString1 = f();
    String[] arrayOfString2 = ResourceTools.getStringArray("types.MethodInfosEditor");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.MethodInfosEditor");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int m = 0; m < arrayOfString3.length; m++)
      arrayOfInt[m] = Integer.parseInt(arrayOfString3[m]);
    locali.a(arrayOfString1, arrayOfInt, arrayOfString2);
    localTable.setLayoutData(new GridData(1808));
    localTable.setHeaderVisible(true);
    localTable.setLinesVisible(true);
    TableEditor localTableEditor = new TableEditor(localTable);
    localTable.addMouseListener(new ad(this, localTable, localTableEditor));
    return localTable;
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new af(this, paramTableItem, paramText, paramInt));
    paramText.addTraverseListener(new ag(this, paramTableItem, paramText, paramInt));
  }

  private void a(TableItem paramTableItem, Text paramText, int paramInt)
  {
    Object localObject;
    if ((paramTableItem != null) && (!paramTableItem.isDisposed()) && (paramTableItem.getParent().equals(this.f)))
    {
      paramTableItem.setText(paramInt, paramText.getText());
      localObject = (TypeMethod)paramTableItem.getData();
      if (paramInt == 0)
        ((TypeMethod)localObject).setFuncName(paramTableItem.getText(0));
      else if (paramInt == 1)
        ((TypeMethod)localObject).setDisName(paramTableItem.getText(1));
      else if (paramInt == 2)
        ((TypeMethod)localObject).setReturnType(paramTableItem.getText(2));
      else if (paramInt == 3)
        ((TypeMethod)localObject).setTypeName(paramTableItem.getText(3));
      else if (paramInt == 4)
        ((TypeMethod)localObject).setFuncBody(paramTableItem.getText(4));
    }
    else if ((paramTableItem != null) && (!paramTableItem.isDisposed()) && (paramTableItem.getParent().equals(this.i)))
    {
      paramTableItem.setText(paramInt, paramText.getText());
      localObject = (GlobalMethod)paramTableItem.getData();
      if (paramInt == 0)
        ((GlobalMethod)localObject).setFuncName(paramTableItem.getText(0));
      else if (paramInt == 2)
        ((GlobalMethod)localObject).setReturnType(paramTableItem.getText(2));
      else if (paramInt == 1)
        ((GlobalMethod)localObject).setDisName(paramTableItem.getText(1));
      else if (paramInt == 3)
        ((GlobalMethod)localObject).setTypeName(paramTableItem.getText(3));
      else if (paramInt == 4)
        ((GlobalMethod)localObject).setFuncBody(paramTableItem.getText(4));
    }
    n();
  }

  private void n()
  {
    if (this.e != null)
    {
      this.e.dispose();
      this.e = null;
    }
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  public static void a(d paramd)
  {
    aa localaa = new aa(paramd);
    Shell localShell = localaa.b(null);
    localShell.addDisposeListener(new ah(localaa));
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
    c();
    b();
    m();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  public void e()
  {
  }

  public void a(Table paramTable)
  {
    String[] arrayOfString = f();
    for (int m = 0; m < arrayOfString.length; m++)
    {
      TableColumn localTableColumn = new TableColumn(paramTable, 8388608);
      localTableColumn.setText(arrayOfString[m]);
      localTableColumn.setWidth(150);
    }
  }

  protected String[] f()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.MethodInfosEditor");
    for (int m = 0; m < arrayOfString.length; m++)
    {
      if (ResourceTools.getMessage(arrayOfString[m] + ".MethodInfosEditor") == null)
        continue;
      arrayOfString[m] = ResourceTools.getMessage(arrayOfString[m] + ".MethodInfosEditor");
    }
    return arrayOfString;
  }

  private boolean a(GlobalMethod paramGlobalMethod)
  {
    TableItem localTableItem = new TableItem(this.i, 0);
    localTableItem.setText(0, paramGlobalMethod.getFuncName());
    localTableItem.setText(1, paramGlobalMethod.getDisName());
    localTableItem.setText(2, paramGlobalMethod.getReturnType());
    localTableItem.setText(3, paramGlobalMethod.getTypeName());
    localTableItem.setText(4, paramGlobalMethod.getFuncBody());
    localTableItem.setData(paramGlobalMethod);
    return true;
  }

  private boolean a(TypeMethod paramTypeMethod)
  {
    TableItem localTableItem = new TableItem(this.f, 0);
    localTableItem.setText(0, paramTypeMethod.getFuncName());
    localTableItem.setText(1, paramTypeMethod.getDisName());
    localTableItem.setText(2, paramTypeMethod.getReturnType());
    localTableItem.setText(3, paramTypeMethod.getTypeName());
    localTableItem.setText(4, paramTypeMethod.getFuncBody());
    localTableItem.setData(paramTypeMethod);
    return true;
  }

  private String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  void g()
  {
    this.a.close();
  }

  private String[] o()
  {
    HashMap localHashMap = new HashMap();
    List localList = this.g.getGlobalMethods();
    Object localObject;
    for (int m = 0; m < localList.size(); m++)
    {
      localObject = (GlobalMethod)localList.get(m);
      if (localHashMap.get(((GlobalMethod)localObject).getTypeName()) != null)
        continue;
      localHashMap.put(((GlobalMethod)localObject).getTypeName(), ((GlobalMethod)localObject).getTypeName());
    }
    if (localHashMap.size() > 0)
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      localObject = new String[localHashMap.size()];
      int n = 0;
      while (localIterator.hasNext())
        localObject[(n++)] = ((String)localIterator.next());
      return localObject;
    }
    return (String)new String[0];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aa
 * JD-Core Version:    0.6.0
 */