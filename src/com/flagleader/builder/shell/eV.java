package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.d.r;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.manager.d.c;
import com.flagleader.repository.collections.a;
import com.flagleader.repository.d.I;
import com.flagleader.repository.rom.CustomVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class eV
{
  Shell a;
  StyledText b;
  private TableEditor i;
  FileDialog c;
  private Text j;
  ToolBar d;
  private int k = 1;
  Statement e = null;
  private boolean l = false;
  private static Image m = ImageDescriptor.createFromURL(eV.class.getClassLoader().getResource("icons/xls.gif")).createImage();
  private static Image n = ImageDescriptor.createFromURL(eV.class.getClassLoader().getResource("icons/shuxin.gif")).createImage();
  private static Image o = ImageDescriptor.createFromURL(eV.class.getClassLoader().getResource("icons/search.gif")).createImage();
  private static Image p = ImageDescriptor.createFromURL(eV.class.getClassLoader().getResource("icons/backward.gif")).createImage();
  private static Image q = ImageDescriptor.createFromURL(eV.class.getClassLoader().getResource("icons/forward.gif")).createImage();
  private Composite r;
  private List s = null;
  private IRulePackage t = null;
  private s u;
  private List v = null;
  private String[] w = null;
  private HashMap[] x = null;
  private Tree y = null;
  private int z = 0;
  TreeColumn f = null;
  private int A = 0;
  private String B = "";
  private int C = 0;
  CellStyle g;
  CellStyle h;

  public eV(List paramList, IRulePackage paramIRulePackage)
  {
    this.s = paramList;
    this.t = paramIRulePackage;
    this.v = this.t.getEnvionment().getRelateVarNames();
    this.w = new String[this.v.size()];
    this.x = new HashMap[this.v.size()];
    for (int i1 = 0; i1 < this.v.size(); i1++)
    {
      this.w[i1] = ((IVariableObject)this.v.get(i1)).getDisplayName();
      this.x[i1] = new HashMap();
    }
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("ExportXlsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new eW(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("SelectColsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new ff(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new fg(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindNextItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new fh(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindPreviousItem"));
    localMenuItem.setAccelerator(16777227);
    localMenuItem.addSelectionListener(new fi(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new fj(this));
    return localMenu2;
  }

  void b()
  {
    this.d = new ToolBar(this.a, 8388672);
    ToolItem localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(m);
    localToolItem.setToolTipText(a("ExportXlsItem"));
    localToolItem.addSelectionListener(new fk(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(n);
    localToolItem.setToolTipText(a("SelectColsItem"));
    localToolItem.addSelectionListener(new fl(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(o);
    localToolItem.setToolTipText(a("FindItem"));
    localToolItem.addSelectionListener(new fm(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(p);
    localToolItem.setToolTipText(a("FindPreviousItem"));
    localToolItem.addSelectionListener(new eX(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(q);
    localToolItem.setToolTipText(a("FindNextItem"));
    localToolItem.addSelectionListener(new eY(this));
  }

  public void c()
  {
    fn localfn = new fn(this);
    if (localfn.open() == 0)
    {
      this.B = localfn.a();
      this.C = localfn.c();
      d();
    }
  }

  public void d()
  {
    if ((this.B == null) || (this.B.length() == 0))
    {
      c();
    }
    else if (this.y.getSelectionCount() > 0)
    {
      TreeItem localTreeItem = this.y.getSelection()[(this.y.getSelectionCount() - 1)];
      if ((localTreeItem.getItemCount() > 0) && (a(localTreeItem.getItems())))
        return;
      a(localTreeItem);
    }
    else
    {
      a(this.y.getItems());
    }
  }

  private boolean a(TreeItem paramTreeItem)
  {
    int i1;
    TreeItem[] arrayOfTreeItem;
    int i2;
    if (paramTreeItem.getParentItem() != null)
    {
      i1 = paramTreeItem.getParentItem().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[paramTreeItem.getParentItem().getItemCount() - i1 - 1];
      for (i2 = i1 + 1; i2 < paramTreeItem.getParentItem().getItemCount(); i2++)
        arrayOfTreeItem[(i2 - i1 - 1)] = paramTreeItem.getParentItem().getItem(i2);
      if (a(arrayOfTreeItem))
        return true;
      if (a(paramTreeItem.getParentItem()))
        return true;
    }
    else if (paramTreeItem.getParent() != null)
    {
      i1 = paramTreeItem.getParent().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[paramTreeItem.getParent().getItemCount() - i1 - 1];
      for (i2 = i1 + 1; i2 < paramTreeItem.getParent().getItemCount(); i2++)
        arrayOfTreeItem[(i2 - i1 - 1)] = paramTreeItem.getParent().getItem(i2);
      if (a(arrayOfTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TreeItem paramTreeItem)
  {
    if (this.C < 0)
    {
      for (int i1 = 2; i1 < this.y.getColumnCount(); i1++)
        if (paramTreeItem.getText(i1).indexOf(this.B) >= 0)
          return true;
      return false;
    }
    return paramTreeItem.getText(this.C + 2).indexOf(this.B) >= 0;
  }

  private boolean a(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      if (b(paramArrayOfTreeItem[i1]))
      {
        if (paramArrayOfTreeItem[i1].getParentItem() != null)
          d(paramArrayOfTreeItem[i1].getParentItem());
        this.y.setSelection(paramArrayOfTreeItem[i1]);
        return true;
      }
      if ((paramArrayOfTreeItem[i1].getItemCount() > 0) && (a(paramArrayOfTreeItem[i1].getItems())))
        return true;
    }
    return false;
  }

  private boolean c(TreeItem paramTreeItem)
  {
    int i1;
    TreeItem[] arrayOfTreeItem;
    int i2;
    if (paramTreeItem.getParentItem() != null)
    {
      i1 = paramTreeItem.getParentItem().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[i1];
      for (i2 = 0; i2 < i1; i2++)
        arrayOfTreeItem[i2] = paramTreeItem.getParentItem().getItem(i2);
      if (b(arrayOfTreeItem))
        return true;
      if (c(paramTreeItem.getParentItem()))
        return true;
    }
    else if (paramTreeItem.getParent() != null)
    {
      i1 = paramTreeItem.getParent().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[i1];
      for (i2 = 0; i2 < i1; i2++)
        arrayOfTreeItem[i2] = paramTreeItem.getParent().getItem(i2);
      if (b(arrayOfTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i1 = paramArrayOfTreeItem.length - 1; i1 >= 0; i1--)
    {
      if ((paramArrayOfTreeItem[i1].getItemCount() > 0) && (a(paramArrayOfTreeItem[i1].getItems())))
        return true;
      if (!b(paramArrayOfTreeItem[i1]))
        continue;
      if (paramArrayOfTreeItem[i1].getParentItem() != null)
        d(paramArrayOfTreeItem[i1].getParentItem());
      this.y.setSelection(paramArrayOfTreeItem[i1]);
      return true;
    }
    return false;
  }

  public void e()
  {
    if ((this.B != null) && (this.B.length() > 0))
      if (this.y.getSelectionCount() > 0)
      {
        TreeItem localTreeItem = this.y.getSelection()[(this.y.getSelectionCount() - 1)];
        c(localTreeItem);
      }
      else
      {
        b(this.y.getItems());
      }
  }

  private void d(TreeItem paramTreeItem)
  {
    paramTreeItem.setExpanded(true);
    if (paramTreeItem.getParentItem() != null)
      d(paramTreeItem.getParentItem());
  }

  private String a(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  private void j()
  {
    a locala = new a(this.t.getEnvionment().getDecisionAssgignVariables(), new eZ(this));
    r localr = new r(new Shell(), locala);
    if (localr.open() == 0)
    {
      List localList = localr.b();
      for (int i1 = 0; i1 < localList.size(); i1++)
        for (int i2 = 2; i2 < this.y.getColumnCount(); i2++)
        {
          if (!this.y.getColumn(i2).getText().equalsIgnoreCase(((CustomVariable)localList.get(i1)).getDisplayName()))
            continue;
          this.y.getColumn(i2).dispose();
          i2--;
        }
    }
  }

  private String[] k()
  {
    String[] arrayOfString = new String[this.y.getColumnCount() - 2];
    for (int i1 = 2; i1 < this.y.getColumnCount(); i1++)
      arrayOfString[(i1 - 2)] = this.y.getColumn(i1).getText();
    return arrayOfString;
  }

  void f()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem = new MenuItem(localMenu, 64);
    localMenuItem.setText(a("FileMenu"));
    localMenuItem.setMenu(a());
  }

  void g()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        Object localObject = null;
        if (localFileDialog.getFileName().endsWith(".xls"))
          localObject = new HSSFWorkbook();
        else
          localObject = new XSSFWorkbook();
        a((Workbook)localObject);
        File localFile = new File(str);
        if (!localFile.exists())
          localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Workbook)localObject).write(localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        MessageDialog.openInformation(new Shell(), a("success.dialog"), c.a("HasBeenExport", new String[] { str }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), a("error.dialog"), localIOException.getMessage());
      }
  }

  void h()
  {
    this.a.close();
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(c.a("title.SnapShotViewer", new String[] { this.t.getDisplayName() }));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new fa(this));
  }

  private void l()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    a(localComposite);
  }

  public Composite a(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.u = new s();
    this.y = this.u.a(localComposite, 8456962);
    GridData localGridData = new GridData(1808);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.y.setLayoutData(localGridData);
    this.y.addMouseListener(new fb(this));
    this.y.removeAll();
    this.f = new TreeColumn(this.y, 8388608);
    this.f.setText("");
    this.f.setWidth(50);
    this.f.setText("");
    TreeColumn localTreeColumn = new TreeColumn(this.y, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(a("rulename.RuleLogViewer"));
    for (int i1 = 0; i1 < this.v.size(); i1++)
    {
      localTreeColumn = new TreeColumn(this.y, 8388608);
      localTreeColumn.setText(((IVariableObject)this.v.get(i1)).getDisplayName());
      localTreeColumn.setWidth(80);
      localTreeColumn.setMoveable(true);
    }
    this.y.addKeyListener(new fc(this));
    m();
    this.y.getHorizontalBar().addSelectionListener(new fd(this));
    this.y.addMouseListener(new fe(this));
    return localComposite;
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    f();
    b();
    l();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  private void m()
  {
    this.a.setText(this.t.getDisplayName());
    for (int i1 = 0; i1 < this.s.size(); i1++)
    {
      String[] arrayOfString = (String[])this.s.get(i1);
      TreeItem localTreeItem = new TreeItem(this.y, 0);
      localTreeItem.setText(0, i1 + 1);
      String str1 = arrayOfString[0];
      if (str1 == null)
        str1 = "";
      localTreeItem.setText(1, str1);
      for (int i2 = 0; i2 < this.v.size(); i2++)
      {
        String str2 = arrayOfString[(i2 + 1)];
        localTreeItem.setText(i2 + 2, str2);
        if ((i1 <= 0) || (str2.equals(((String[])this.s.get(i1 - 1))[(i2 + 1)])))
          continue;
        localTreeItem.setForeground(i2 + 2, h.g);
      }
      localTreeItem.setExpanded(true);
    }
    this.y.update();
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  public String i()
  {
    if (this.y == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    TreeColumn[] arrayOfTreeColumn = this.y.getColumns();
    for (int i1 = 1; i1 < arrayOfTreeColumn.length; i1++)
      localStringBuffer.append(arrayOfTreeColumn[i1].getText() + ",");
    localStringBuffer.append("\n");
    TreeItem[] arrayOfTreeItem = this.y.getItems();
    for (int i2 = 0; i2 < arrayOfTreeItem.length; i2++)
    {
      for (int i3 = 1; i3 < arrayOfTreeColumn.length; i3++)
        if (arrayOfTreeItem[i2].getData(String.valueOf(i3)) != null)
          localStringBuffer.append((String)arrayOfTreeItem[i2].getData(String.valueOf(i3)) + ",");
        else
          localStringBuffer.append(arrayOfTreeItem[i2].getText(i3) + ",");
      localStringBuffer.append("\n");
    }
    return localStringBuffer.toString();
  }

  private Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    this.g = paramWorkbook.createCellStyle();
    this.g.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
    this.g.setFillPattern(1);
    this.h = paramWorkbook.createCellStyle();
    this.h.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
    this.h.setFillPattern(1);
    localSheet = paramWorkbook.createSheet(this.t.getDisplayName());
    this.A = 0;
    Row localRow = localSheet.createRow(this.A++);
    TreeColumn[] arrayOfTreeColumn = this.y.getColumns();
    Cell localCell;
    for (int i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localCell = localRow.createCell(i1);
      localCell.setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.y.getItems(), 0);
    localSheet.createFreezePane(2, 1);
    localSheet = paramWorkbook.createSheet("changed");
    this.A = 0;
    localRow = localSheet.createRow(this.A++);
    arrayOfTreeColumn = this.y.getColumns();
    for (i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localCell = localRow.createCell(i1);
      localCell.setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.y.getItems(), 1);
    localSheet.createFreezePane(2, 1);
    return paramWorkbook;
  }

  private void a(Sheet paramSheet, TreeItem[] paramArrayOfTreeItem, int paramInt)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      Row localRow = paramSheet.createRow(this.A++);
      for (int i2 = 0; i2 < this.w.length + 2; i2++)
      {
        Cell localCell = localRow.createCell(i2);
        String str1 = paramArrayOfTreeItem[i1].getText(i2);
        if (paramArrayOfTreeItem[i1].getData(String.valueOf(i2)) != null)
          str1 = (String)paramArrayOfTreeItem[i1].getData(String.valueOf(i2));
        String str2 = "";
        if (i2 == 0)
        {
          int i3 = 0;
          for (i3 = str1.indexOf("."); i3 != -1; i3 = str1.indexOf(".", i3 + 1))
            str2 = str2 + "    ";
          str1 = str2 + str1;
        }
        if (i2 > 1)
        {
          if (paramInt == 1)
          {
            String str3 = str1;
            String str4 = str1;
            if (i1 > 0)
              str3 = paramArrayOfTreeItem[(i1 - 1)].getText(i2);
            try
            {
              localCell.setCellValue(Double.parseDouble(str4) - Double.parseDouble(str3));
            }
            catch (Throwable localThrowable)
            {
              localCell.setCellValue(str1);
            }
          }
          else if (paramInt == 0)
          {
            localCell.setCellValue(str1);
          }
        }
        else
          localCell.setCellValue(str1);
        if (!paramArrayOfTreeItem[i1].getForeground(i2).equals(h.g))
          continue;
        localCell.setCellStyle(this.g);
      }
      if (paramArrayOfTreeItem[i1].getItemCount() <= 0)
        continue;
      a(paramSheet, paramArrayOfTreeItem[i1].getItems(), paramInt);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eV
 * JD-Core Version:    0.6.0
 */