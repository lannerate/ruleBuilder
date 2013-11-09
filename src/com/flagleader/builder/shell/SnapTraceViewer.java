package com.flagleader.builder.shell;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.IRuleLog;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.I;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.SerializationUtils;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class SnapTraceViewer
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
  private LinkedList n = null;
  private s o;
  private Tree p = null;
  private int q = 0;
  private List r;
  TreeColumn f = null;
  private int s = 0;
  private String t = "";
  private int u = 0;
  CellStyle g;
  CellStyle h;
  private HashMap v = null;
  private String w = "";
  private String x;
  private BuilderManager y;

  public SnapTraceViewer(LinkedList paramLinkedList, IRulePackage paramIRulePackage, BuilderManager paramBuilderManager)
  {
    this.n = paramLinkedList;
    this.w = paramIRulePackage.getDisplayName();
    this.y = paramBuilderManager;
  }

  public SnapTraceViewer(BuilderManager paramBuilderManager)
  {
    this.y = paramBuilderManager;
  }

  public SnapTraceViewer()
  {
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("OpenItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 79);
    localMenuItem.addSelectionListener(new fo(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("SaveItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new fv(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("ExportXlsItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 80);
    localMenuItem.addSelectionListener(new fw(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("FindItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 70);
    localMenuItem.addSelectionListener(new fx(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("FindNextItem"));
    localMenuItem.setAccelerator(16777228);
    localMenuItem.addSelectionListener(new fy(this));
    localMenuItem = new MenuItem(localMenu2, 64);
    localMenuItem.setText(c("FindPreviousItem"));
    localMenuItem.setAccelerator(16777227);
    localMenuItem.addSelectionListener(new fz(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new fA(this));
    return localMenu2;
  }

  void b()
  {
    this.d = new ToolBar(this.a, 8388672);
    ToolItem localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("OpenItem.icon"));
    localToolItem.setToolTipText(c("OpenItem"));
    localToolItem.addSelectionListener(new fB(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("SaveItem.icon"));
    localToolItem.setToolTipText(c("SaveItem"));
    localToolItem.addSelectionListener(new fC(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("exportxls.icon"));
    localToolItem.setToolTipText(c("ExportXlsItem"));
    localToolItem.addSelectionListener(new fp(this));
    localToolItem = new ToolItem(this.d, 2);
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("searchobj.icon"));
    localToolItem.setToolTipText(c("FindItem"));
    localToolItem.addSelectionListener(new fq(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("presheet.icon"));
    localToolItem.setToolTipText(c("FindPreviousItem"));
    localToolItem.addSelectionListener(new fr(this));
    localToolItem = new ToolItem(this.d, 8);
    localToolItem.setImage(ResourceTools.getImage("nextsheet.icon"));
    localToolItem.setToolTipText(c("FindNextItem"));
    localToolItem.addSelectionListener(new fs(this));
  }

  public void c()
  {
    fD localfD = new fD(this);
    if (localfD.open() == 0)
    {
      this.t = localfD.a();
      this.u = localfD.c();
      d();
    }
  }

  public void d()
  {
    if ((this.t == null) || (this.t.length() == 0))
    {
      c();
    }
    else if (this.p.getSelectionCount() > 0)
    {
      TreeItem localTreeItem = this.p.getSelection()[(this.p.getSelectionCount() - 1)];
      if ((localTreeItem.getItemCount() > 0) && (a(localTreeItem.getItems())))
        return;
      a(localTreeItem);
    }
    else
    {
      a(this.p.getItems());
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
    if (this.u < 0)
    {
      for (int i1 = 2; i1 < this.p.getColumnCount(); i1++)
        if (paramTreeItem.getText(i1).indexOf(this.t) >= 0)
          return true;
      return false;
    }
    return paramTreeItem.getText(this.u + 2).indexOf(this.t) >= 0;
  }

  private boolean a(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      if (b(paramArrayOfTreeItem[i1]))
      {
        if (paramArrayOfTreeItem[i1].getParentItem() != null)
          d(paramArrayOfTreeItem[i1].getParentItem());
        this.p.setSelection(paramArrayOfTreeItem[i1]);
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
      this.p.setSelection(paramArrayOfTreeItem[i1]);
      return true;
    }
    return false;
  }

  public void e()
  {
    if ((this.t != null) && (this.t.length() > 0))
      if (this.p.getSelectionCount() > 0)
      {
        TreeItem localTreeItem = this.p.getSelection()[(this.p.getSelectionCount() - 1)];
        c(localTreeItem);
      }
      else
      {
        b(this.p.getItems());
      }
  }

  private String c(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  private String[] i()
  {
    String[] arrayOfString = new String[this.p.getColumnCount() - 2];
    for (int i1 = 2; i1 < this.p.getColumnCount(); i1++)
      arrayOfString[(i1 - 2)] = this.p.getColumn(i1).getText();
    return arrayOfString;
  }

  void f()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem = new MenuItem(localMenu, 64);
    localMenuItem.setText(c("FileMenu"));
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
        MessageDialog.openInformation(new Shell(), c("success.dialog"), c.a("HasBeenExport", new String[] { str }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), c("error.dialog"), localIOException.getMessage());
      }
  }

  void h()
  {
    this.a.close();
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(c.a("title.RuleLogViewer", new String[] { this.w }));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new ft(this));
  }

  private void j()
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
    this.o = new s();
    this.p = this.o.a(localComposite, 8456962);
    GridData localGridData = new GridData(1808);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.p.setLayoutData(localGridData);
    this.p.addMouseListener(new fu(this));
    this.f = new TreeColumn(this.p, 8388608);
    this.f.setText("");
    this.f.setWidth(100);
    this.f.setText(c("rulename.RuleLogViewer"));
    TreeColumn localTreeColumn = new TreeColumn(this.p, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(c("condition.RuleLogViewer"));
    localTreeColumn = new TreeColumn(this.p, 8388608);
    localTreeColumn.setText(c("changes.RuleLogViewer"));
    localTreeColumn.setWidth(500);
    localTreeColumn.setMoveable(true);
    k();
    return localComposite;
  }

  private void k()
  {
    this.p.removeAll();
    l();
  }

  public static void main(String[] paramArrayOfString)
  {
    SnapTraceViewer localSnapTraceViewer = new SnapTraceViewer();
    Shell localShell = localSnapTraceViewer.b(null);
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
    f();
    b();
    j();
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
    if (this.v.get(paramTreeItem) == null)
    {
      this.v.put(paramTreeItem, paramTreeItem);
      if (paramTreeItem.getParentItem() != null)
        e(paramTreeItem.getParentItem());
    }
  }

  private boolean d(String paramString)
  {
    if ((this.r == null) || (this.r.size() == 0))
      return true;
    for (int i1 = 0; i1 < this.r.size(); i1++)
    {
      IVariableObject localIVariableObject = (IVariableObject)this.r.get(i1);
      if (localIVariableObject.getShowDisplayName().equals(paramString))
        return true;
    }
    return false;
  }

  private String e(String paramString)
  {
    if (paramString.indexOf("-") > 0)
      return paramString.substring(paramString.lastIndexOf("-") + 1);
    return paramString;
  }

  private void l()
  {
    if (this.n == null)
      return;
    if (this.w != null)
      this.a.setText(this.w);
    for (int i1 = 0; i1 < this.n.size(); i1++)
    {
      IRuleLog localIRuleLog = (IRuleLog)this.n.get(i1);
      TreeItem localTreeItem = new TreeItem(this.p, 0);
      localTreeItem.setText(0, i1 + 1 + e(localIRuleLog.getRuleName()));
      localTreeItem.setData(localIRuleLog);
      String str1 = localIRuleLog.getRuleProcess();
      if (str1 == null)
        str1 = "";
      localTreeItem.setText(1, str1);
      String[] arrayOfString = localIRuleLog.getFieldNames();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i2 = 0; (arrayOfString != null) && (i2 < arrayOfString.length); i2++)
      {
        if (!d(arrayOfString[i2]))
          continue;
        String str2 = localIRuleLog.getInitValue(arrayOfString[i2]);
        String str3 = localIRuleLog.getResultValue(arrayOfString[i2]);
        localStringBuffer.append("{").append(arrayOfString[i2]).append(":");
        if (str2 == null)
        {
          if (str3 != null)
          {
            localTreeItem.setForeground(i2 + 2, h.g);
            if (str3.length() > 50)
              localStringBuffer.append("->").append(str3.substring(0, 50)).append("...");
            else
              localStringBuffer.append("->").append(str3);
          }
        }
        else if ((str3 == null) || (str2.equals(str3)))
        {
          if (str2.length() > 50)
            localStringBuffer.append(str2.substring(0, 50)).append("...");
          else
            localStringBuffer.append(str2);
        }
        else
        {
          localTreeItem.setForeground(i2 + 2, h.g);
          if (str2.length() > 50)
            localStringBuffer.append(str2.substring(0, 50)).append("...");
          else
            localStringBuffer.append(str2);
          localStringBuffer.append("->");
          if (str3.length() > 50)
            localStringBuffer.append(str3.substring(0, 50)).append("...");
          else
            localStringBuffer.append(str3);
        }
        localStringBuffer.append("}\n");
      }
      localTreeItem.setText(2, localStringBuffer.toString());
      if (localIRuleLog.hasChild())
        for (i2 = 0; i2 < localIRuleLog.getChildRules().size(); i2++)
          a(localTreeItem, (IRuleLog)localIRuleLog.getChildRules().get(i2), i1 + 1 + "." + (i2 + 1));
      localTreeItem.setExpanded(true);
    }
    this.p.update();
  }

  private void a(TreeItem paramTreeItem, IRuleLog paramIRuleLog, String paramString)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramString + e(paramIRuleLog.getRuleName()));
    localTreeItem.setData(paramIRuleLog);
    String str1 = paramIRuleLog.getRuleProcess();
    if (str1 == null)
      str1 = "";
    localTreeItem.setText(1, str1);
    String[] arrayOfString = paramIRuleLog.getFieldNames();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = 0; (arrayOfString != null) && (i1 < arrayOfString.length); i1++)
    {
      if (!d(arrayOfString[i1]))
        continue;
      String str2 = paramIRuleLog.getInitValue(arrayOfString[i1]);
      String str3 = paramIRuleLog.getResultValue(arrayOfString[i1]);
      localStringBuffer.append("{").append(arrayOfString[i1]).append(":");
      if (str2 == null)
      {
        if (str3 != null)
        {
          localTreeItem.setForeground(i1 + 2, h.g);
          if (str3.length() > 50)
            localStringBuffer.append(str3.substring(0, 50)).append("...");
          else
            localStringBuffer.append(str3);
        }
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        if (str2.length() > 50)
          localStringBuffer.append(str2.substring(0, 50)).append("...");
        else
          localStringBuffer.append(str2);
      }
      else
      {
        localTreeItem.setForeground(i1 + 2, h.g);
        if (str2.length() > 50)
          localStringBuffer.append(str2.substring(0, 50)).append("...");
        else
          localStringBuffer.append(str2);
        localStringBuffer.append("->");
        if (str3.length() > 50)
          localStringBuffer.append(str3.substring(0, 50)).append("...");
        else
          localStringBuffer.append(str3);
      }
      localStringBuffer.append("}\n");
    }
    localTreeItem.setText(2, localStringBuffer.toString());
    if (paramIRuleLog.hasChild())
      for (i1 = 0; i1 < paramIRuleLog.getChildRules().size(); i1++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(i1), paramString + "." + (i1 + 1));
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  private void m()
  {
    try
    {
      if (this.n != null)
      {
        FileDialog localFileDialog = new FileDialog(this.a, 8192);
        localFileDialog.setFilterExtensions(new String[] { "*.rlg" });
        if (this.x != null)
        {
          localFileDialog.setFilterPath(new File(this.x).getParent());
          localFileDialog.setFileName(new File(this.x).getName());
        }
        else
        {
          localFileDialog.setFileName(this.w);
        }
        this.x = localFileDialog.open();
        f(this.x);
      }
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getLocalizedMessage());
    }
  }

  private void f(String paramString)
  {
    if (paramString != null)
      SerializationUtils.serialize(this.n, new FileOutputStream(paramString));
  }

  private void n()
  {
    if (this.c == null)
      this.c = new FileDialog(this.a, 4096);
    this.c.setFilterExtensions(new String[] { "*.rlg", "*.*" });
    String str = this.c.open();
    b(str);
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      String str1 = MessageFormat.format(c("Err_file_no_exist"), new String[] { localFile.getName() });
      a(str1);
      return;
    }
    try
    {
      this.n = ((LinkedList)SerializationUtils.deserialize(new FileInputStream(paramString)));
    }
    catch (Exception localException)
    {
      String str2 = MessageFormat.format(c("Err_file_io"), new String[] { localFile.getName() });
      a(str2);
    }
    this.x = paramString;
    k();
  }

  private String o()
  {
    if (this.p == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    TreeColumn[] arrayOfTreeColumn = this.p.getColumns();
    for (int i1 = 1; i1 < arrayOfTreeColumn.length; i1++)
      localStringBuffer.append(arrayOfTreeColumn[i1].getText() + ",");
    localStringBuffer.append("\n");
    TreeItem[] arrayOfTreeItem = this.p.getItems();
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

  private String g(String paramString)
  {
    paramString = paramString.replace('/', '_');
    return paramString;
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
    localSheet = paramWorkbook.createSheet(this.w);
    this.s = 0;
    Row localRow = localSheet.createRow(this.s++);
    TreeColumn[] arrayOfTreeColumn = this.p.getColumns();
    Object localObject;
    for (int i1 = 0; i1 < arrayOfTreeColumn.length; i1++)
    {
      localObject = localRow.createCell(i1);
      ((Cell)localObject).setCellValue(arrayOfTreeColumn[i1].getText());
    }
    a(localSheet, this.p.getItems(), null);
    localSheet.createFreezePane(2, 1);
    for (i1 = 0; (this.r != null) && (i1 < this.r.size()); i1++)
    {
      localObject = (IVariableObject)this.r.get(i1);
      localSheet = paramWorkbook.createSheet(g(((IVariableObject)localObject).getShowDisplayName()));
      this.s = 0;
      localRow = localSheet.createRow(this.s++);
      arrayOfTreeColumn = this.p.getColumns();
      for (int i2 = 0; i2 < arrayOfTreeColumn.length; i2++)
      {
        Cell localCell = localRow.createCell(i2);
        localCell.setCellValue(arrayOfTreeColumn[i2].getText());
      }
      a(localSheet, this.p.getItems(), ((IVariableObject)localObject).getShowDisplayName());
      localSheet.createFreezePane(2, 1);
    }
    return (Workbook)paramWorkbook;
  }

  private void a(Sheet paramSheet, TreeItem[] paramArrayOfTreeItem, String paramString)
  {
    for (int i1 = 0; i1 < paramArrayOfTreeItem.length; i1++)
    {
      Row localRow = paramSheet.createRow(this.s++);
      for (int i2 = 0; i2 < 3; i2++)
      {
        Cell localCell1 = localRow.createCell(i2);
        String str1 = paramArrayOfTreeItem[i1].getText(i2);
        if (paramArrayOfTreeItem[i1].getData(String.valueOf(i2)) != null)
          str1 = (String)paramArrayOfTreeItem[i1].getData(String.valueOf(i2));
        String str2 = "";
        if (i2 == 0)
        {
          int i3 = 0;
          for (i3 = str1.indexOf("."); i3 != -1; i3 = str1.indexOf(".", i3 + 1))
            str2 = str2 + "  ";
          str1 = str2 + str1;
          localCell1.setCellValue(str1);
        }
        else if (i2 == 1)
        {
          localCell1.setCellValue(str1);
        }
        else if (paramString == null)
        {
          localCell1.setCellValue(str1);
        }
        else
        {
          String[] arrayOfString = str1.split("\n");
          for (int i4 = 0; i4 < arrayOfString.length; i4++)
          {
            int i5 = arrayOfString[i4].indexOf(":");
            if ((i5 <= 1) || (!arrayOfString[i4].substring(1, i5).equals(paramString)))
              continue;
            String str3 = arrayOfString[i4].substring(i5 + 1);
            int i6 = str3.indexOf("->");
            Cell localCell2;
            if (i6 > 0)
            {
              localCell1.setCellValue(str3.substring(0, i6));
              localCell2 = localRow.createCell(3);
              localCell2.setCellValue(str3.substring(i6 + 3, str3.length() - 1));
            }
            else
            {
              localCell2 = localRow.createCell(3);
              localCell2.setCellValue(str3);
            }
          }
        }
      }
      if (paramArrayOfTreeItem[i1].getItemCount() <= 0)
        continue;
      a(paramSheet, paramArrayOfTreeItem[i1].getItems(), paramString);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.SnapTraceViewer
 * JD-Core Version:    0.6.0
 */