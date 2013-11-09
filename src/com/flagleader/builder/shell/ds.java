package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.d.r;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.IRuleLog;
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
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class ds
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
  private Composite m;
  private IRuleLog n = null;
  private IRulePackage o = null;
  private s p;
  private List q = null;
  private String[] r = null;
  private HashMap[] s = null;
  private Tree t = null;
  private int u = 0;
  TreeColumn f = null;
  private int v = 0;
  private String w = "";
  private int x = 0;
  CellStyle g;
  CellStyle h;
  private HashMap y = null;

  public ds(IRuleLog paramIRuleLog, IRulePackage paramIRulePackage)
  {
    this.n = paramIRuleLog;
    this.o = paramIRulePackage;
    this.q = this.o.getEnvionment().getRelateVarNames();
    this.r = new String[this.q.size()];
    this.s = new HashMap[this.q.size()];
    for (int i1 = 0; i1 < this.q.size(); i1++)
    {
      this.r[i1] = ((IVariableObject)this.q.get(i1)).getDisplayName();
      this.s[i1] = new HashMap();
    }
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("ExportXlsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new dt(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("SelectColsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new dD(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new dE(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindNextItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new dF(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(a("FindPreviousItem"));
    localMenuItem.setAccelerator(16777227);
    localMenuItem.addSelectionListener(new dG(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new dH(this));
    return localMenu2;
  }

  void b()
  {
    this.d = new ToolBar(this.a, 8388672);
    ToolItem localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("exportxls.icon"));
    localToolItem.setToolTipText(a("ExportXlsItem"));
    localToolItem.addSelectionListener(new dI(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("PropertiesItem.icon"));
    localToolItem.setToolTipText(a("SelectColsItem"));
    localToolItem.addSelectionListener(new dJ(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("searchobj.icon"));
    localToolItem.setToolTipText(a("FindItem"));
    localToolItem.addSelectionListener(new dK(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("presheet.icon"));
    localToolItem.setToolTipText(a("FindPreviousItem"));
    localToolItem.addSelectionListener(new du(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("nextsheet.icon"));
    localToolItem.setToolTipText(a("FindNextItem"));
    localToolItem.addSelectionListener(new dv(this));
  }

  public void c()
  {
    dL localdL = new dL(this);
    if (localdL.open() == 0)
    {
      this.w = localdL.a();
      this.x = localdL.c();
      d();
    }
  }

  public void d()
  {
    if ((this.w == null) || (this.w.length() == 0))
    {
      c();
    }
    else if (this.t.getSelectionCount() > 0)
    {
      TreeItem localTreeItem = this.t.getSelection()[(this.t.getSelectionCount() - 1)];
      if ((localTreeItem.getItemCount() > 0) && (a(localTreeItem.getItems())))
        return;
      a(localTreeItem);
    }
    else
    {
      a(this.t.getItems());
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
    if (this.x < 0)
    {
      for (int i1 = 2; i1 < this.t.getColumnCount(); i1++)
        if (paramTreeItem.getText(i1).indexOf(this.w) >= 0)
          return true;
      return false;
    }
    return paramTreeItem.getText(this.x + 2).indexOf(this.w) >= 0;
  }

  private boolean a(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      if (b(paramArrayOfTreeItem[i1]))
      {
        if (paramArrayOfTreeItem[i1].getParentItem() != null)
          d(paramArrayOfTreeItem[i1].getParentItem());
        this.t.setSelection(paramArrayOfTreeItem[i1]);
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
      this.t.setSelection(paramArrayOfTreeItem[i1]);
      return true;
    }
    return false;
  }

  public void e()
  {
    if ((this.w != null) && (this.w.length() > 0))
      if (this.t.getSelectionCount() > 0)
      {
        TreeItem localTreeItem = this.t.getSelection()[(this.t.getSelectionCount() - 1)];
        c(localTreeItem);
      }
      else
      {
        b(this.t.getItems());
      }
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
    a locala = new a(this.o.getEnvionment().getDecisionAssgignVariables(), new dw(this));
    r localr = new r(new Shell(), locala);
    if (localr.open() == 0)
    {
      List localList = localr.b();
      for (int i1 = 0; i1 < localList.size(); i1++)
        for (int i2 = 2; i2 < this.t.getColumnCount(); i2++)
        {
          if (!this.t.getColumn(i2).getText().equalsIgnoreCase(((CustomVariable)localList.get(i1)).getDisplayName()))
            continue;
          this.t.getColumn(i2).dispose();
          i2--;
        }
    }
  }

  private String[] k()
  {
    String[] arrayOfString = new String[this.t.getColumnCount() - 2];
    for (int i1 = 2; i1 < this.t.getColumnCount(); i1++)
      arrayOfString[(i1 - 2)] = this.t.getColumn(i1).getText();
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
    localFileDialog.setFilterExtensions(new String[] { "*.xls", ".xlsx" });
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
    this.a.setText(c.a("title.RuleLogViewer", new String[] { this.o.getDisplayName() }));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new dx(this));
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
    this.p = new s();
    this.t = this.p.a(localComposite, 8456962);
    GridData localGridData = new GridData(1808);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.t.setLayoutData(localGridData);
    this.t.addMouseListener(new dy(this));
    this.t.removeAll();
    this.f = new TreeColumn(this.t, 8388608);
    this.f.setText("");
    this.f.setWidth(100);
    this.f.setText(a("rulename.RuleLogViewer"));
    TreeColumn localTreeColumn = new TreeColumn(this.t, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(a("condition.RuleLogViewer"));
    for (int i1 = 0; i1 < this.q.size(); i1++)
    {
      localTreeColumn = new TreeColumn(this.t, 8388608);
      localTreeColumn.setText(((IVariableObject)this.q.get(i1)).getDisplayName());
      localTreeColumn.setWidth(80);
      localTreeColumn.setMoveable(true);
      int i2 = i1 + 2;
      localTreeColumn.addSelectionListener(new dz(this, i2));
    }
    this.t.addKeyListener(new dA(this));
    m();
    this.t.getHorizontalBar().addSelectionListener(new dB(this));
    this.t.addMouseListener(new dC(this));
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

  private void a(TreeItem paramTreeItem, int paramInt)
  {
    int i1 = 0;
    for (int i2 = 0; i2 < paramTreeItem.getItemCount(); i2++)
    {
      TreeItem localTreeItem = paramTreeItem.getItems()[i2];
      if (localTreeItem.getItemCount() > 0)
        a(localTreeItem, paramInt);
      else
        if (i1 != 0)
          continue;
      if (!localTreeItem.getForeground(paramInt).equals(h.g))
        continue;
      e(paramTreeItem);
      i1 = 1;
    }
  }

  private void d(TreeItem paramTreeItem)
  {
    paramTreeItem.setExpanded(true);
    if (paramTreeItem.getParentItem() != null)
      d(paramTreeItem.getParentItem());
  }

  private void e(TreeItem paramTreeItem)
  {
    if (this.y.get(paramTreeItem) == null)
    {
      this.y.put(paramTreeItem, paramTreeItem);
      if (paramTreeItem.getParentItem() != null)
        e(paramTreeItem.getParentItem());
    }
  }

  private void b(TreeItem paramTreeItem, int paramInt)
  {
    if (paramTreeItem == null)
      return;
    if (this.s[paramInt].get(paramTreeItem) == null)
    {
      this.s[paramInt].put(paramTreeItem, paramTreeItem);
      if (paramTreeItem.getParentItem() != null)
        b(paramTreeItem.getParentItem(), paramInt);
    }
  }

  private void m()
  {
    this.a.setText(this.n.getRuleName());
    for (int i1 = 0; (this.n.hasChild()) && (i1 < this.n.getChildRules().size()); i1++)
    {
      IRuleLog localIRuleLog = (IRuleLog)this.n.getChildRules().get(i1);
      TreeItem localTreeItem = new TreeItem(this.t, 0);
      localTreeItem.setText(0, i1 + 1 + localIRuleLog.getRuleName());
      String str1 = localIRuleLog.getRuleProcess();
      if (str1 == null)
        str1 = "";
      localTreeItem.setText(1, str1);
      for (int i2 = 0; i2 < this.q.size(); i2++)
      {
        String str2 = localIRuleLog.getInitValue(this.r[i2]);
        String str3 = localIRuleLog.getResultValue(this.r[i2]);
        if (str2 == null)
        {
          if (str3 == null)
            continue;
          localTreeItem.setForeground(i1 + 2, h.g);
          localTreeItem.setText(i1 + 2, str3);
        }
        else if ((str3 == null) || (str2.equals(str3)))
        {
          localTreeItem.setText(i1 + 2, str2);
        }
        else
        {
          localTreeItem.setForeground(i2 + 2, h.g);
          localTreeItem.setText(i2 + 2, str2 + " - " + str3);
          b(localTreeItem.getParentItem(), i2);
        }
      }
      if (localIRuleLog.hasChild())
        for (i2 = 0; i2 < localIRuleLog.getChildRules().size(); i2++)
          a(localTreeItem, (IRuleLog)localIRuleLog.getChildRules().get(i2), i1 + 1 + "." + (i2 + 1));
      localTreeItem.setExpanded(true);
    }
    this.t.update();
  }

  private void a(TreeItem paramTreeItem, IRuleLog paramIRuleLog, String paramString)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramString + paramIRuleLog.getRuleName());
    String str1 = paramIRuleLog.getRuleProcess();
    if (str1 == null)
      str1 = "";
    localTreeItem.setText(1, str1);
    for (int i1 = 0; i1 < this.q.size(); i1++)
    {
      String str2 = paramIRuleLog.getInitValue(this.r[i1]);
      String str3 = paramIRuleLog.getResultValue(this.r[i1]);
      if (str2 == null)
      {
        if (str3 == null)
          continue;
        localTreeItem.setForeground(i1 + 2, h.g);
        localTreeItem.setText(i1 + 2, str3);
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        localTreeItem.setText(i1 + 2, str2);
      }
      else
      {
        localTreeItem.setForeground(i1 + 2, h.g);
        localTreeItem.setText(i1 + 2, str2 + " - " + str3);
        b(localTreeItem.getParentItem(), i1);
      }
    }
    if (paramIRuleLog.hasChild())
      for (i1 = 0; i1 < paramIRuleLog.getChildRules().size(); i1++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(i1), paramString + "." + (i1 + 1));
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  public String i()
  {
    if (this.t == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    TreeColumn[] arrayOfTreeColumn = this.t.getColumns();
    for (int i1 = 1; i1 < arrayOfTreeColumn.length; i1++)
      localStringBuffer.append(arrayOfTreeColumn[i1].getText() + ",");
    localStringBuffer.append("\n");
    TreeItem[] arrayOfTreeItem = this.t.getItems();
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
    localSheet = paramWorkbook.createSheet(this.o.getDisplayName());
    this.v = 0;
    Row localRow = localSheet.createRow(this.v++);
    TreeColumn[] arrayOfTreeColumn = this.t.getColumns();
    Cell localCell;
    for (int i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localCell = localRow.createCell(i1);
      localCell.setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.t.getItems(), 0);
    localSheet.createFreezePane(2, 1);
    localSheet = paramWorkbook.createSheet("row");
    this.v = 0;
    localRow = localSheet.createRow(this.v++);
    arrayOfTreeColumn = this.t.getColumns();
    for (i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localCell = localRow.createCell(i1);
      localCell.setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.t.getItems(), 1);
    localSheet.createFreezePane(2, 1);
    localSheet = paramWorkbook.createSheet("result");
    this.v = 0;
    localRow = localSheet.createRow(this.v++);
    arrayOfTreeColumn = this.t.getColumns();
    for (i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localCell = localRow.createCell(i1);
      localCell.setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.t.getItems(), 2);
    localSheet.createFreezePane(2, 1);
    return paramWorkbook;
  }

  private void a(Sheet paramSheet, TreeItem[] paramArrayOfTreeItem, int paramInt)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      Row localRow = paramSheet.createRow(this.v++);
      for (int i2 = 0; i2 < this.r.length + 2; i2++)
      {
        Cell localCell = localRow.createCell(i2);
        String str1 = paramArrayOfTreeItem[i1].getText(i2);
        if (paramArrayOfTreeItem[i1].getData(String.valueOf(i2)) != null)
          str1 = (String)paramArrayOfTreeItem[i1].getData(String.valueOf(i2));
        String str2 = "";
        if (i2 == 0)
        {
          i3 = 0;
          for (i3 = str1.indexOf("."); i3 != -1; i3 = str1.indexOf(".", i3 + 1))
            str2 = str2 + "    ";
          str1 = str2 + str1;
        }
        int i3 = str1.indexOf(" - ");
        if (i3 > 0)
        {
          if (paramInt == 0)
          {
            String str3 = str1.substring(0, i3);
            String str4 = str1.substring(i3 + 3);
            try
            {
              localCell.setCellValue(Double.parseDouble(str4) - Double.parseDouble(str3));
            }
            catch (Throwable localThrowable)
            {
              localCell.setCellValue(str1);
            }
          }
          else if (paramInt == 1)
          {
            localCell.setCellValue(str1.substring(0, i3));
          }
          else if (paramInt == 2)
          {
            localCell.setCellValue(str1.substring(i3 + 3));
          }
        }
        else
          localCell.setCellValue(str1);
        if (paramArrayOfTreeItem[i1].getForeground(i2).equals(h.g))
        {
          localCell.setCellStyle(this.g);
        }
        else
        {
          if (i3 <= 0)
            continue;
          localCell.setCellStyle(this.h);
        }
      }
      if (paramArrayOfTreeItem[i1].getItemCount() <= 0)
        continue;
      a(paramSheet, paramArrayOfTreeItem[i1].getItems(), paramInt);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ds
 * JD-Core Version:    0.6.0
 */