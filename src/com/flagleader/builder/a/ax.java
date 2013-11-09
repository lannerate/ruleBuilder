package com.flagleader.builder.a;

import com.flagleader.builder.widget.i;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.DateUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TypeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class ax extends aS
{
  private TableTree q;
  private TableEditor r;
  private TableTreeItem s;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  private static Image t = i.a;
  private static Image u = i.b;
  private String v = "";
  private int w = 0;
  private int x = 0;
  private HashMap y = null;
  private Text z;
  private CCombo A;

  public ax(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected void h()
  {
    a(new aJ(this));
    a(new aI(this));
    a(new aH(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "moveUp");
    a(paramToolBar, "moveDown");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "undo");
    a(paramToolBar, "redo");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "exportxls");
    super.a(paramToolBar);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    TableTree localTableTree = b(localComposite);
    localTableTree.setData(this.c);
    return localComposite;
  }

  public void update()
  {
    if (!i())
      return;
    this.q.update();
    this.q.removeAll();
    Control[] arrayOfControl = this.q.getTable().getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    t();
    if ((e()) && (this.q.getItemCount() > 1))
      g();
    super.update();
  }

  protected boolean e()
  {
    return true;
  }

  protected int f()
  {
    return 1;
  }

  protected void g()
  {
    for (int i = f(); i < this.q.getTable().getColumnCount(); i++)
      this.q.getTable().getColumn(i).pack();
  }

  protected boolean i()
  {
    return (this.b != null) && (!this.b.isDisposed()) && ((this.a == null) || (equals(this.a.e())));
  }

  private void a(IElement[] paramArrayOfIElement)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfIElement.length);
    for (int i = 0; i < paramArrayOfIElement.length; i++)
      for (j = 0; j < this.q.getItems().length; j++)
        if (this.q.getItems()[j].getData() == paramArrayOfIElement[i])
        {
          localArrayList.add(this.q.getItem(j));
        }
        else
        {
          if (this.q.getItems()[j].getItemCount() <= 0)
            continue;
          for (int k = 0; k < this.q.getItems()[j].getItemCount(); k++)
          {
            if (this.q.getItem(j).getItem(k).getData() != paramArrayOfIElement[i])
              continue;
            localArrayList.add(this.q.getItem(j).getItem(k));
          }
        }
    TableTreeItem[] arrayOfTableTreeItem = new TableTreeItem[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfTableTreeItem[j] = ((TableTreeItem)localArrayList.get(j));
    this.q.setSelection(arrayOfTableTreeItem);
  }

  protected int j()
  {
    return this.q.getSelectionCount();
  }

  protected IElement[] k()
  {
    if (this.q.getSelectionCount() > 0)
    {
      IElement[] arrayOfIElement = new IElement[this.q.getSelectionCount()];
      TableTreeItem[] arrayOfTableTreeItem = this.q.getSelection();
      for (int i = 0; i < arrayOfTableTreeItem.length; i++)
      {
        if ((arrayOfTableTreeItem[i].getData() == null) || (!(arrayOfTableTreeItem[i].getData() instanceof IElement)))
          continue;
        arrayOfIElement[i] = ((IElement)arrayOfTableTreeItem[i].getData());
      }
      return arrayOfIElement;
    }
    return null;
  }

  protected int l()
  {
    if (this.q.getSelectionCount() > 0)
    {
      int i = this.q.indexOf(this.q.getSelection()[0]);
      if (i > 0)
      {
        IElement localIElement = (IElement)this.q.getItem(i - 1).getData();
        if ((localIElement != null) && (localIElement.getParent() != null))
          return localIElement.getParent().getElementPos(localIElement);
      }
    }
    return 0;
  }

  protected int m()
  {
    if (this.q.getSelectionCount() > 0)
    {
      int i = this.q.indexOf(this.q.getSelection()[(this.q.getSelectionCount() - 1)]);
      if (i < this.q.getItemCount() - 1)
      {
        IElement localIElement = (IElement)this.q.getItem(i + 1).getData();
        if ((localIElement != null) && (localIElement.getParent() != null))
          return localIElement.getParent().getElementPos(localIElement);
      }
    }
    return 0;
  }

  protected String[] a(int paramInt)
  {
    TableTreeItem[] arrayOfTableTreeItem = this.q.getItems();
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < arrayOfTableTreeItem.length; i++)
    {
      if (arrayOfTableTreeItem[i].getText(paramInt) == null)
        continue;
      localHashMap.put(arrayOfTableTreeItem[i].getText(paramInt), arrayOfTableTreeItem[i].getText(paramInt));
    }
    Iterator localIterator = localHashMap.keySet().iterator();
    String[] arrayOfString = new String[localHashMap.keySet().size()];
    int j = 0;
    while (localIterator.hasNext())
      arrayOfString[(j++)] = localIterator.next().toString();
    return arrayOfString;
  }

  private void D()
  {
    TableColumn[] arrayOfTableColumn = this.q.getTable().getColumns();
    for (int i = 0; i < arrayOfTableColumn.length; i++)
      arrayOfTableColumn[i].setImage(null);
  }

  protected abstract String[] n();

  protected abstract String[] o();

  protected abstract String[] p();

  protected int a(int paramInt, IElement paramIElement)
  {
    return 0;
  }

  protected boolean q()
  {
    return false;
  }

  protected boolean a(IElement paramIElement, boolean paramBoolean)
  {
    return true;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    return false;
  }

  protected boolean r()
  {
    return false;
  }

  protected void a(int paramInt, boolean paramBoolean)
  {
  }

  protected TableTree b(Composite paramComposite)
  {
    int i = 67586;
    if (q())
      i |= 32;
    this.q = new TableTree(paramComposite, i);
    Table localTable = this.q.getTable();
    localTable.setLinesVisible(true);
    String[] arrayOfString1 = n();
    String[] arrayOfString2 = o();
    int j = arrayOfString1.length;
    for (int k = 0; k < j; k++)
    {
      TableColumn localTableColumn = new TableColumn(localTable, 0);
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[k]));
      localTableColumn.setText(arrayOfString1[k]);
      if (!r())
        continue;
      int m = k;
      localTableColumn.addSelectionListener(new ay(this, localTableColumn, m));
    }
    localTable.setHeaderVisible(true);
    this.q.setLayoutData(new GridData(1808));
    this.r = new TableEditor(localTable);
    localTable.addMouseListener(new az(this));
    localTable.addMouseMoveListener(new aA(this));
    localTable.addKeyListener(new aB(this));
    if ((q()) && (!b()))
      this.q.addSelectionListener(new aC(this));
    return this.q;
  }

  private IElement a(String paramString)
  {
    for (int i = 0; i < this.q.getItemCount(); i++)
      if ((this.q.getItem(i).getData() != null) && (((IElement)this.q.getItem(i).getData()).getUuid().equals(paramString)))
        return (IElement)this.q.getItem(i).getData();
    return null;
  }

  protected boolean a(Menu paramMenu, IElement[] paramArrayOfIElement, int paramInt)
  {
    a(paramMenu, "update");
    return true;
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.keyCode == 16777217) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0) && (this.q.getSelectionCount() >= 1))
    {
      a(k(), l());
      paramKeyEvent.doit = false;
    }
    if ((paramKeyEvent.keyCode == 16777218) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0) && (this.q.getSelectionCount() >= 1))
    {
      b(k(), m());
      paramKeyEvent.doit = false;
    }
    super.a(paramKeyEvent);
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new aD(this, paramText, paramInt));
    paramText.addTraverseListener(new aE(this, paramText, paramInt));
  }

  private void a(TableTreeItem paramTableTreeItem, TableItem paramTableItem, CCombo paramCCombo, TableEditor paramTableEditor, int paramInt)
  {
    a(paramCCombo, paramInt);
    paramCCombo.setText(paramTableItem.getText(paramInt));
    if (paramCCombo.getItemCount() < 20)
      paramCCombo.setVisibleItemCount(paramCCombo.getItemCount());
    else
      paramCCombo.setVisibleItemCount(20);
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.minimumWidth = 50;
    paramTableEditor.setEditor(paramCCombo, paramTableItem, paramInt);
    paramCCombo.addFocusListener(new aF(this, paramCCombo, paramInt));
    paramCCombo.addTraverseListener(new aG(this, paramCCombo, paramInt));
  }

  protected synchronized void a(String paramString, int paramInt)
  {
    if ((paramString != null) && (!b()))
      b(paramString, paramInt);
    s();
  }

  protected void b(String paramString, int paramInt)
  {
    if ((this.s != null) && (!this.s.isDisposed()) && (a((IElement)this.s.getData(), paramInt, paramString)) && (!this.s.isDisposed()))
    {
      this.s.setText(paramInt, paramString);
      c(this.s);
    }
  }

  protected void s()
  {
    this.r.setEditor(null, null, -1);
    if (this.z != null)
    {
      this.z.dispose();
      this.z = null;
    }
    if ((this.A != null) && (!this.A.isDisposed()))
    {
      this.A.dispose();
      this.A = null;
    }
  }

  protected void a(Item paramItem)
  {
    paramItem.dispose();
  }

  protected void b(Item paramItem)
  {
    ((TableTreeItem)paramItem).setExpanded(true);
  }

  protected void c(Item paramItem)
  {
    TableTreeItem localTableTreeItem = (TableTreeItem)paramItem;
    while (localTableTreeItem.getItemCount() > 0)
      localTableTreeItem.getItems()[0].dispose();
    a(localTableTreeItem, (IElement)localTableTreeItem.getData());
    localTableTreeItem.setExpanded(true);
  }

  protected abstract void t();

  protected Item d(Item paramItem)
  {
    if (paramItem == null)
      return new TableTreeItem(this.q, 0);
    return new TableTreeItem((TableTreeItem)paramItem, 0);
  }

  protected void a(Item paramItem, Color paramColor)
  {
    ((TableTreeItem)paramItem).setBackground(paramColor);
  }

  protected void a(Item paramItem, boolean paramBoolean, String[] paramArrayOfString)
  {
    TableTreeItem localTableTreeItem = (TableTreeItem)paramItem;
    for (int i = 0; (paramArrayOfString != null) && (i < paramArrayOfString.length); i++)
      localTableTreeItem.setText(i, paramArrayOfString[i]);
    if (q())
      localTableTreeItem.setChecked(paramBoolean);
  }

  protected abstract void a(Item paramItem, IElement paramIElement);

  protected boolean a(IElement[] paramArrayOfIElement, int paramInt)
  {
    if ((b()) || (paramArrayOfIElement == null) || (paramArrayOfIElement.length == 0))
      return false;
    IElement localIElement = paramArrayOfIElement[0].getParent();
    for (int i = 0; i < paramArrayOfIElement.length; i++)
    {
      int j = localIElement.getElementPos(paramArrayOfIElement[i]);
      if (j < paramInt)
        continue;
      localIElement.moveElement(j, paramInt);
    }
    this.c.setModified(true);
    update();
    a(paramArrayOfIElement);
    return true;
  }

  protected boolean b(IElement[] paramArrayOfIElement, int paramInt)
  {
    if ((b()) || (paramArrayOfIElement == null) || (paramArrayOfIElement.length == 0))
      return false;
    IElement localIElement = paramArrayOfIElement[0].getParent();
    for (int i = paramArrayOfIElement.length - 1; i >= 0; i--)
    {
      int j = localIElement.getElementPos(paramArrayOfIElement[i]);
      localIElement.moveElement(j, paramInt);
    }
    this.c.setModified(true);
    update();
    a(paramArrayOfIElement);
    return true;
  }

  public boolean canCopy()
  {
    return (this.q.getTable().isFocusControl()) && (this.q.getSelection().length > 0);
  }

  public boolean canCut()
  {
    if (b())
      return false;
    return (this.q.getTable().isFocusControl()) && (this.q.getSelection().length > 0);
  }

  public boolean canDelete()
  {
    if (b())
      return false;
    return (this.q.getTable().isFocusControl()) && (this.q.getSelection().length > 0);
  }

  public void selectAll()
  {
    this.q.setSelection(this.q.getItems());
    setChanged();
    notifyObservers();
  }

  public boolean isCanSelectAll()
  {
    return true;
  }

  public boolean isCanFind()
  {
    return true;
  }

  public void find()
  {
    aK localaK = new aK(this);
    if (localaK.open() == 0)
    {
      this.v = localaK.a();
      this.w = localaK.c();
      findNext();
    }
  }

  public void findNext()
  {
    if ((this.v == null) || (this.v.length() == 0))
    {
      find();
    }
    else if (this.q.getSelectionCount() > 0)
    {
      TableTreeItem localTableTreeItem = this.q.getSelection()[(this.q.getSelectionCount() - 1)];
      if ((localTableTreeItem.getItemCount() > 0) && (a(localTableTreeItem.getItems())))
        return;
      a(localTableTreeItem);
    }
    else
    {
      a(this.q.getItems());
    }
  }

  private boolean a(TableTreeItem paramTableTreeItem)
  {
    int i;
    TableTreeItem[] arrayOfTableTreeItem;
    int j;
    if (paramTableTreeItem.getParentItem() != null)
    {
      i = paramTableTreeItem.getParentItem().indexOf(paramTableTreeItem);
      arrayOfTableTreeItem = new TableTreeItem[paramTableTreeItem.getParentItem().getItemCount() - i - 1];
      for (j = i + 1; j < paramTableTreeItem.getParentItem().getItemCount(); j++)
        arrayOfTableTreeItem[(j - i - 1)] = paramTableTreeItem.getParentItem().getItem(j);
      if (a(arrayOfTableTreeItem))
        return true;
      if (a(paramTableTreeItem.getParentItem()))
        return true;
    }
    else if (paramTableTreeItem.getParent() != null)
    {
      i = paramTableTreeItem.getParent().indexOf(paramTableTreeItem);
      arrayOfTableTreeItem = new TableTreeItem[paramTableTreeItem.getParent().getItemCount() - i - 1];
      for (j = i + 1; j < paramTableTreeItem.getParent().getItemCount(); j++)
        arrayOfTableTreeItem[(j - i - 1)] = paramTableTreeItem.getParent().getItem(j);
      if (a(arrayOfTableTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TableTreeItem paramTableTreeItem)
  {
    if (this.w < 0)
    {
      for (int i = 0; i < this.q.getTable().getColumnCount(); i++)
        if ((paramTableTreeItem.getText(i) != null) && (paramTableTreeItem.getText(i).indexOf(this.v) >= 0))
          return true;
      return false;
    }
    return paramTableTreeItem.getText(this.w).indexOf(this.v) >= 0;
  }

  private boolean a(TableTreeItem[] paramArrayOfTableTreeItem)
  {
    for (int i = 0; i < paramArrayOfTableTreeItem.length; i++)
    {
      if (b(paramArrayOfTableTreeItem[i]))
      {
        if (paramArrayOfTableTreeItem[i].getParentItem() != null)
          d(paramArrayOfTableTreeItem[i].getParentItem());
        this.q.setSelection(new TableTreeItem[] { paramArrayOfTableTreeItem[i] });
        return true;
      }
      if ((paramArrayOfTableTreeItem[i].getItemCount() > 0) && (a(paramArrayOfTableTreeItem[i].getItems())))
        return true;
    }
    return false;
  }

  private boolean c(TableTreeItem paramTableTreeItem)
  {
    int i;
    TableTreeItem[] arrayOfTableTreeItem;
    int j;
    if (paramTableTreeItem.getParentItem() != null)
    {
      i = paramTableTreeItem.getParentItem().indexOf(paramTableTreeItem);
      arrayOfTableTreeItem = new TableTreeItem[i];
      for (j = 0; j < i; j++)
        arrayOfTableTreeItem[j] = paramTableTreeItem.getParentItem().getItem(j);
      if (b(arrayOfTableTreeItem))
        return true;
      if (c(paramTableTreeItem.getParentItem()))
        return true;
    }
    else if (paramTableTreeItem.getParent() != null)
    {
      i = paramTableTreeItem.getParent().indexOf(paramTableTreeItem);
      arrayOfTableTreeItem = new TableTreeItem[i];
      for (j = 0; j < i; j++)
        arrayOfTableTreeItem[j] = paramTableTreeItem.getParent().getItem(j);
      if (b(arrayOfTableTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TableTreeItem[] paramArrayOfTableTreeItem)
  {
    for (int i = paramArrayOfTableTreeItem.length - 1; i >= 0; i--)
    {
      if ((paramArrayOfTableTreeItem[i].getItemCount() > 0) && (a(paramArrayOfTableTreeItem[i].getItems())))
        return true;
      if (!b(paramArrayOfTableTreeItem[i]))
        continue;
      if (paramArrayOfTableTreeItem[i].getParentItem() != null)
        d(paramArrayOfTableTreeItem[i].getParentItem());
      this.q.setSelection(new TableTreeItem[] { paramArrayOfTableTreeItem[i] });
      return true;
    }
    return false;
  }

  public void u()
  {
    if ((this.v != null) && (this.v.length() > 0))
      if (this.q.getSelectionCount() > 0)
      {
        TableTreeItem localTableTreeItem = this.q.getSelection()[(this.q.getSelectionCount() - 1)];
        c(localTableTreeItem);
      }
      else
      {
        b(this.q.getItems());
      }
  }

  private String[] E()
  {
    String[] arrayOfString = new String[this.q.getTable().getColumnCount()];
    for (int i = 0; i < this.q.getTable().getColumnCount(); i++)
      arrayOfString[i] = this.q.getTable().getColumn(i).getText();
    return arrayOfString;
  }

  protected boolean v()
  {
    return true;
  }

  protected void w()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(this.c.getDisplayName());
    if (localFileDialog.open() != null)
      try
      {
        Object localObject = null;
        if (localFileDialog.getFileName().endsWith(".xls"))
          localObject = new HSSFWorkbook();
        else
          localObject = new XSSFWorkbook();
        a((Workbook)localObject);
        File localFile = new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
        if (!localFile.exists())
          localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Workbook)localObject).write(localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        MessageDialog.openInformation(new Shell(), "", c.a("HasBeenExport", new String[] { localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName() }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }

  private Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet(this.c.getDisplayName());
    this.x = 0;
    Row localRow = localSheet.createRow(this.x++);
    TableColumn[] arrayOfTableColumn = this.q.getTable().getColumns();
    for (int i = 0; i < arrayOfTableColumn.length; i++)
    {
      Cell localCell = localRow.createCell(i);
      localCell.setCellValue(arrayOfTableColumn[i].getText());
    }
    localSheet.createFreezePane(0, 1, 0, 1);
    a(localSheet, this.q.getItems());
    return paramWorkbook;
  }

  private void a(Sheet paramSheet, TableTreeItem[] paramArrayOfTableTreeItem)
  {
    for (int i = 0; i < paramArrayOfTableTreeItem.length; i++)
    {
      Row localRow = paramSheet.createRow(this.x++);
      for (int j = 0; j < this.q.getTable().getColumnCount(); j++)
      {
        Cell localCell = localRow.createCell(j);
        String str = paramArrayOfTableTreeItem[i].getText(j);
        localCell.setCellValue(str);
      }
    }
  }

  private void d(TableTreeItem paramTableTreeItem)
  {
    paramTableTreeItem.setExpanded(true);
    if (paramTableTreeItem.getParentItem() != null)
      d(paramTableTreeItem.getParentItem());
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.q.getTable().getItemCount() == 0)
      return;
    if (this.y == null)
      this.y = new HashMap();
    else
      this.y.clear();
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getSystemCursor(1));
    TableTreeItem[] arrayOfTableTreeItem = this.q.getItems();
    ArrayList localArrayList1 = new ArrayList(arrayOfTableTreeItem.length);
    ArrayList localArrayList2 = new ArrayList(1);
    int i = 0;
    if (TypeUtil.isNumber(paramString))
      i = 1;
    else if (TypeUtil.isDate(paramString))
      i = 2;
    else if (TypeUtil.isTime(paramString))
      i = 3;
    else if (TypeUtil.isDatetime(paramString))
      i = 4;
    else if (TypeUtil.isBoolean(paramString))
      i = 5;
    else
      i = 0;
    String[] arrayOfString;
    int n;
    try
    {
      int j = n().length;
      for (int m = 0; m < arrayOfTableTreeItem.length; m++)
      {
        arrayOfString = new String[j];
        for (n = 0; n < j; n++)
          arrayOfString[n] = arrayOfTableTreeItem[m].getText(n);
        if (arrayOfTableTreeItem[m].getData() == null)
        {
          localArrayList2.add(arrayOfString);
        }
        else
        {
          if (m == 0)
          {
            if ((paramInt >= j) || (paramInt < 0))
              return;
            localArrayList1.add(arrayOfString);
          }
          else
          {
            switch (i)
            {
            case 1:
              localArrayList1.add(i.a(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, NumberUtil.getDouble(arrayOfString[paramInt])), arrayOfString);
              break;
            case 2:
              localArrayList1.add(i.a(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, DateUtil.getDate(arrayOfString[paramInt])), arrayOfString);
              break;
            case 3:
              localArrayList1.add(i.b(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, DateUtil.getTime(arrayOfString[paramInt])), arrayOfString);
              break;
            case 4:
              localArrayList1.add(i.c(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, DateUtil.getDateTime(arrayOfString[paramInt])), arrayOfString);
              break;
            case 5:
              localArrayList1.add(i.a(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, NumberUtil.getBoolean(arrayOfString[paramInt])), arrayOfString);
              break;
            default:
              localArrayList1.add(i.a(localArrayList1, paramInt, paramBoolean, 0, localArrayList1.size() - 1, StringUtil.stringValue(arrayOfString[paramInt])), arrayOfString);
            }
          }
          this.y.put(arrayOfString, arrayOfTableTreeItem[m].getData());
        }
      }
    }
    catch (Exception localException)
    {
      return;
    }
    this.q.removeAll();
    TableTreeItem localTableTreeItem;
    for (int k = 0; k < localArrayList1.size(); k++)
    {
      localTableTreeItem = new TableTreeItem(this.q, 0);
      a(localTableTreeItem, (IElement)this.y.get(localArrayList1.get(k)));
      localTableTreeItem.setExpanded(true);
    }
    for (k = 0; k < localArrayList2.size(); k++)
    {
      localTableTreeItem = new TableTreeItem(this.q, 0);
      arrayOfString = (String[])localArrayList2.get(k);
      for (n = 0; (arrayOfString != null) && (n < arrayOfString.length); n++)
      {
        if (arrayOfString[n] == null)
          continue;
        localTableTreeItem.setText(n, arrayOfString[n]);
      }
    }
    this.q.update();
    if ((e()) && (this.q.getItemCount() > 1))
      g();
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.ax
 * JD-Core Version:    0.6.0
 */