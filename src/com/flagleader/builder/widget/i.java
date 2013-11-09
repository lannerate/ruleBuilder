package com.flagleader.builder.widget;

import com.flagleader.builder.ResourceTools;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.I;
import com.flagleader.repository.lang.b;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.util.DateUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TypeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class i
{
  private Table e = null;
  public static Image a = ImageDescriptor.createFromURL(i.class.getClassLoader().getResource("icons/down.gif")).createImage();
  public static Image b = ImageDescriptor.createFromURL(i.class.getClassLoader().getResource("icons/up.gif")).createImage();
  private int f = 0;
  private HashMap g = new HashMap();
  private boolean h = true;
  private boolean i = true;
  public static final int c = 30;
  private Text j;
  private TableEditor k;
  private String l = "";
  private int m = 0;
  private int n = 0;
  private g[] o;
  CellStyle d;
  private int p = 0;

  public i(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.h = paramBoolean1;
    this.i = paramBoolean2;
  }

  public Table a(Composite paramComposite, int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    this.e = new Table(paramComposite, paramInt);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.k = new TableEditor(this.e);
    if (this.h)
      this.e.addMouseListener(new j(this));
    this.e.addKeyListener(new k(this));
    return this.e;
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new l(this));
    paramText.addTraverseListener(new m(this));
  }

  private void e()
  {
    this.k.setEditor(null, null, -1);
    if (this.j != null)
    {
      this.j.dispose();
      this.j = null;
    }
  }

  public Table a(Composite paramComposite, String paramString, int paramInt)
  {
    a(paramComposite, paramInt);
    a(paramString);
    return this.e;
  }

  public void a(String paramString)
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns" + paramString);
    String[] arrayOfString2 = ResourceTools.getStringArray("types" + paramString);
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths" + paramString);
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i1 = 0; i1 < arrayOfString3.length; i1++)
      arrayOfInt[i1] = Integer.parseInt(arrayOfString3[i1]);
    for (i1 = 0; i1 < arrayOfString1.length; i1++)
      arrayOfString1[i1] = ResourceTools.getMessage(arrayOfString1[i1] + paramString, arrayOfString1[i1]);
    a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  public void a(String[] paramArrayOfString1, int[] paramArrayOfInt, String[] paramArrayOfString2)
  {
    this.f = paramArrayOfString1.length;
    if (paramArrayOfString2 != null)
    {
      this.o = new g[paramArrayOfString2.length];
      for (i1 = 0; i1 < paramArrayOfString2.length; i1++)
        this.o[i1] = b.a().b().a(paramArrayOfString2[i1]);
    }
    for (int i1 = 0; i1 < this.f; i1++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(paramArrayOfString1[i1]);
      if ((paramArrayOfInt != null) && (i1 < paramArrayOfInt.length))
        localTableColumn.setWidth(paramArrayOfInt[i1]);
      else
        localTableColumn.setWidth(100);
      int i2 = i1;
      if (!this.i)
        continue;
      localTableColumn.addSelectionListener(new n(this, localTableColumn, paramArrayOfString2, i2));
    }
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.e.getItemCount() == 0)
      return;
    this.g.clear();
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getSystemCursor(1));
    TableItem[] arrayOfTableItem = this.e.getItems();
    ArrayList localArrayList = new ArrayList(this.e.getItemCount());
    int i1 = 0;
    if (TypeUtil.isNumber(paramString))
      i1 = 1;
    else if (TypeUtil.isDate(paramString))
      i1 = 2;
    else if (TypeUtil.isTime(paramString))
      i1 = 3;
    else if (TypeUtil.isDatetime(paramString))
      i1 = 4;
    else if (TypeUtil.isBoolean(paramString))
      i1 = 5;
    else
      i1 = 0;
    try
    {
      for (int i2 = 0; i2 < this.e.getItemCount(); i2++)
      {
        String[] arrayOfString = new String[this.f];
        for (int i4 = 0; i4 < this.f; i4++)
          arrayOfString[i4] = arrayOfTableItem[i2].getText(i4);
        if (i2 == 0)
        {
          if ((paramInt >= this.f) || (paramInt < 0))
            return;
          localArrayList.add(arrayOfString);
        }
        else
        {
          switch (i1)
          {
          case 1:
            localArrayList.add(a(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, NumberUtil.getDouble(arrayOfString[paramInt])), arrayOfString);
            break;
          case 2:
            localArrayList.add(a(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, DateUtil.getDate(arrayOfString[paramInt])), arrayOfString);
            break;
          case 3:
            localArrayList.add(b(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, DateUtil.getTime(arrayOfString[paramInt])), arrayOfString);
            break;
          case 4:
            localArrayList.add(c(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, DateUtil.getDateTime(arrayOfString[paramInt])), arrayOfString);
            break;
          case 5:
            localArrayList.add(a(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, NumberUtil.getBoolean(arrayOfString[paramInt])), arrayOfString);
            break;
          default:
            localArrayList.add(a(localArrayList, paramInt, paramBoolean, 0, localArrayList.size() - 1, StringUtil.stringValue(arrayOfString[paramInt])), arrayOfString);
          }
        }
        this.g.put(arrayOfString, arrayOfTableItem[i2].getData());
      }
    }
    catch (Exception localException)
    {
      return;
    }
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i3 = 0; i3 < arrayOfControl.length; i3++)
      arrayOfControl[i3].dispose();
    for (i3 = 0; i3 < localArrayList.size(); i3++)
    {
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText((String[])localArrayList.get(i3));
      localTableItem.setData(this.g.get(localArrayList.get(i3)));
    }
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(null);
  }

  public static int a(List paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, Date paramDate)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (a(paramDate, DateUtil.getDate(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean))
        return paramInt2;
      if (a(paramDate, DateUtil.getDate(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (a(paramDate, DateUtil.getDate(((String[])paramList.get(i1))[paramInt1]), paramBoolean))
      return a(paramList, paramInt1, paramBoolean, paramInt2, i1, paramDate);
    return a(paramList, paramInt1, paramBoolean, i1 + 1, paramInt3, paramDate);
  }

  public static int b(List paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, Date paramDate)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (b(paramDate, DateUtil.getTime(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean))
        return paramInt2;
      if (b(paramDate, DateUtil.getTime(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (b(paramDate, DateUtil.getTime(((String[])paramList.get(i1))[paramInt1]), paramBoolean))
      return b(paramList, paramInt1, paramBoolean, paramInt2, i1, paramDate);
    return b(paramList, paramInt1, paramBoolean, i1 + 1, paramInt3, paramDate);
  }

  public static int c(List paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, Date paramDate)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (c(paramDate, DateUtil.getDateTime(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean))
        return paramInt2;
      if (c(paramDate, DateUtil.getDateTime(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (c(paramDate, DateUtil.getDateTime(((String[])paramList.get(i1))[paramInt1]), paramBoolean))
      return c(paramList, paramInt1, paramBoolean, paramInt2, i1, paramDate);
    return c(paramList, paramInt1, paramBoolean, i1 + 1, paramInt3, paramDate);
  }

  public static int a(List paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (a(paramDouble, NumberUtil.getDouble(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean))
        return paramInt2;
      if (a(paramDouble, NumberUtil.getDouble(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (a(paramDouble, NumberUtil.getDouble(((String[])paramList.get(i1))[paramInt1]), paramBoolean))
      return a(paramList, paramInt1, paramBoolean, paramInt2, i1, paramDouble);
    return a(paramList, paramInt1, paramBoolean, i1 + 1, paramInt3, paramDouble);
  }

  public static int a(List paramList, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (a(paramBoolean2, NumberUtil.getBoolean(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean1))
        return paramInt2;
      if (a(paramBoolean2, NumberUtil.getBoolean(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean1))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (a(paramBoolean2, NumberUtil.getBoolean(((String[])paramList.get(i1))[paramInt1]), paramBoolean1))
      return a(paramList, paramInt1, paramBoolean1, paramInt2, i1, paramBoolean2);
    return a(paramList, paramInt1, paramBoolean1, i1 + 1, paramInt3, paramBoolean2);
  }

  public static int a(List paramList, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramInt2 + 1 >= paramInt3) || (paramInt3 <= 0))
    {
      if (a(paramString, StringUtil.stringValue(((String[])paramList.get(paramInt2))[paramInt1]), paramBoolean))
        return paramInt2;
      if (a(paramString, StringUtil.stringValue(((String[])paramList.get(paramInt3))[paramInt1]), paramBoolean))
        return paramInt3;
      return paramInt3 + 1;
    }
    int i1 = (paramInt2 + paramInt3) / 2;
    if (a(paramString, StringUtil.stringValue(((String[])paramList.get(i1))[paramInt1]), paramBoolean))
      return a(paramList, paramInt1, paramBoolean, paramInt2, i1, paramString);
    return a(paramList, paramInt1, paramBoolean, i1 + 1, paramInt3, paramString);
  }

  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (paramBoolean1) && (!paramBoolean2))
      return true;
    return (!paramBoolean3) && (!paramBoolean1) && (paramBoolean2);
  }

  public static boolean a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramDouble1 > paramDouble2))
      return true;
    return (!paramBoolean) && (paramDouble1 < paramDouble2);
  }

  public static boolean a(Date paramDate1, Date paramDate2, boolean paramBoolean)
  {
    if ((paramBoolean) && (DateUtil.moreThanDate(paramDate1, paramDate2, 0)))
      return true;
    return (!paramBoolean) && (DateUtil.lessThanDate(paramDate1, paramDate2, 0));
  }

  public static boolean b(Date paramDate1, Date paramDate2, boolean paramBoolean)
  {
    if ((paramBoolean) && (DateUtil.moreThanTime(paramDate1, paramDate2, 0)))
      return true;
    return (!paramBoolean) && (DateUtil.lessThanTime(paramDate1, paramDate2, 0));
  }

  public static boolean c(Date paramDate1, Date paramDate2, boolean paramBoolean)
  {
    if ((paramBoolean) && (DateUtil.moreThanDatetime(paramDate1, paramDate2, 0)))
      return true;
    return (!paramBoolean) && (DateUtil.lessThanDatetime(paramDate1, paramDate2, 0));
  }

  private static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (StringUtil.moreThan(paramString1, paramString2)))
      return true;
    return (!paramBoolean) && (StringUtil.lessThan(paramString1, paramString2));
  }

  private void f()
  {
    TableColumn[] arrayOfTableColumn = this.e.getColumns();
    for (int i1 = 0; i1 < arrayOfTableColumn.length; i1++)
      arrayOfTableColumn[i1].setImage(null);
  }

  public void a()
  {
    o localo = new o(this);
    if (localo.open() == 0)
    {
      this.l = localo.a();
      this.m = localo.c();
      this.e.deselectAll();
      b();
    }
  }

  public void b()
  {
    if ((this.l == null) || (this.l.length() == 0))
    {
      a();
    }
    else if (this.e.getSelectionCount() > 0)
    {
      TableItem localTableItem = this.e.getSelection()[(this.e.getSelectionCount() - 1)];
      a(localTableItem);
    }
    else
    {
      a(this.e.getItems());
    }
  }

  private boolean a(TableItem paramTableItem)
  {
    if (paramTableItem.getParent() != null)
    {
      int i1 = paramTableItem.getParent().indexOf(paramTableItem);
      TableItem[] arrayOfTableItem = new TableItem[paramTableItem.getParent().getItemCount() - i1 - 1];
      for (int i2 = i1 + 1; i2 < paramTableItem.getParent().getItemCount(); i2++)
        arrayOfTableItem[(i2 - i1 - 1)] = paramTableItem.getParent().getItem(i2);
      if (a(arrayOfTableItem))
        return true;
    }
    return false;
  }

  private boolean b(TableItem paramTableItem)
  {
    if (this.m < 0)
    {
      for (int i1 = 0; i1 < this.e.getColumnCount(); i1++)
        if (paramTableItem.getText(i1).indexOf(this.l) >= 0)
          return true;
      return false;
    }
    return paramTableItem.getText(this.m).indexOf(this.l) >= 0;
  }

  private boolean a(TableItem[] paramArrayOfTableItem)
  {
    for (int i1 = 0; i1 < paramArrayOfTableItem.length; i1++)
    {
      if (!b(paramArrayOfTableItem[i1]))
        continue;
      this.e.setSelection(paramArrayOfTableItem[i1]);
      return true;
    }
    return false;
  }

  private boolean c(TableItem paramTableItem)
  {
    if (paramTableItem.getParent() != null)
    {
      int i1 = paramTableItem.getParent().indexOf(paramTableItem);
      TableItem[] arrayOfTableItem = new TableItem[i1];
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfTableItem[i2] = paramTableItem.getParent().getItem(i2);
      if (b(arrayOfTableItem))
        return true;
    }
    return false;
  }

  private boolean b(TableItem[] paramArrayOfTableItem)
  {
    for (int i1 = paramArrayOfTableItem.length - 1; i1 >= 0; i1--)
    {
      if (!b(paramArrayOfTableItem[i1]))
        continue;
      this.e.setSelection(paramArrayOfTableItem[i1]);
      return true;
    }
    return false;
  }

  public void c()
  {
    if ((this.l != null) && (this.l.length() > 0))
      if (this.e.getSelectionCount() > 0)
      {
        TableItem localTableItem = this.e.getSelection()[(this.e.getSelectionCount() - 1)];
        c(localTableItem);
      }
      else
      {
        b(this.e.getItems());
      }
  }

  private String[] g()
  {
    String[] arrayOfString = new String[this.e.getColumnCount()];
    for (int i1 = 0; i1 < this.e.getColumnCount(); i1++)
      arrayOfString[i1] = this.e.getColumn(i1).getText();
    return arrayOfString;
  }

  public void a(int paramInt)
  {
    this.p = paramInt;
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
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
      catch (Exception localException)
      {
        MessageDialog.openError(new Shell(), "file error!", localException.getMessage());
      }
  }

  private Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    this.d = paramWorkbook.createCellStyle();
    this.d.setDataFormat(paramWorkbook.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    localSheet = paramWorkbook.createSheet("sheet");
    this.n = 0;
    Row localRow = localSheet.createRow(this.n++);
    TableColumn[] arrayOfTableColumn = this.e.getColumns();
    for (int i1 = this.p; i1 < arrayOfTableColumn.length; i1++)
    {
      Cell localCell = localRow.createCell(i1 - this.p);
      localCell.setCellValue(arrayOfTableColumn[i1].getText());
    }
    localSheet.createFreezePane(0, 1, 0, 1);
    a(localSheet, this.e.getItems());
    return paramWorkbook;
  }

  private void a(Sheet paramSheet, TableItem[] paramArrayOfTableItem)
  {
    for (int i1 = 0; i1 < paramArrayOfTableItem.length; i1++)
    {
      Row localRow = paramSheet.createRow(this.n++);
      for (int i2 = this.p; i2 < this.e.getColumnCount(); i2++)
      {
        Cell localCell = localRow.createCell(i2 - this.p);
        String str1 = paramArrayOfTableItem[i1].getText(i2);
        if (paramArrayOfTableItem[i1].getData(String.valueOf(i2)) != null)
          str1 = (String)paramArrayOfTableItem[i1].getData(String.valueOf(i2));
        String str2 = "";
        if (i2 == 0)
        {
          int i3 = 0;
          for (i3 = str1.indexOf("."); i3 != -1; i3 = str1.indexOf(".", i3 + 1))
            str2 = str2 + "    ";
          str1 = str2 + str1;
        }
        if (this.o == null)
          localCell.setCellValue(str1);
        else if ((this.o[i2].b()) || (this.o[i2].j()))
        {
          if (str1.equalsIgnoreCase("NaN"))
            localCell.setCellValue(0.0D);
          else
            localCell.setCellValue(NumberUtil.parseDouble(str1));
        }
        else if (this.o[i2].e())
          localCell.setCellValue(NumberUtil.parseBoolean(str1));
        else if (this.o[i2].G())
          try
          {
            localCell.setCellValue(DateUtil.getDate(str1));
            localCell.setCellStyle(this.d);
          }
          catch (Exception localException)
          {
            localCell.setCellValue(str1);
          }
        else
          localCell.setCellValue(str1);
      }
    }
  }

  public Table d()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.i
 * JD-Core Version:    0.6.0
 */