package com.flagleader.builder.widget;

import com.flagleader.builder.ResourceTools;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class s
{
  private Tree a = null;
  private static Image b = ImageDescriptor.createFromURL(s.class.getClassLoader().getResource("icons/down.gif")).createImage();
  private static Image c = ImageDescriptor.createFromURL(s.class.getClassLoader().getResource("icons/up.gif")).createImage();
  private int d = 0;
  private String e = "";
  private boolean f = false;
  private int g = 0;
  private int h = 0;

  public Tree a(Composite paramComposite, int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    this.a = new Tree(paramComposite, paramInt);
    this.a.setLayoutData(new GridData(1808));
    this.a.setHeaderVisible(true);
    this.a.setLinesVisible(true);
    this.a.addKeyListener(new t(this));
    return this.a;
  }

  public Tree a(Composite paramComposite, String paramString, int paramInt)
  {
    a(paramComposite, paramInt);
    a(paramString);
    return this.a;
  }

  public void a(String paramString)
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns" + paramString);
    String[] arrayOfString2 = ResourceTools.getStringArray("types" + paramString);
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths" + paramString);
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = ResourceTools.getMessage(arrayOfString1[i] + paramString, arrayOfString1[i]);
    a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  public void a(String[] paramArrayOfString1, int[] paramArrayOfInt, String[] paramArrayOfString2)
  {
    this.d = paramArrayOfString1.length;
    for (int i = 0; i < this.d; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.a, 8388608);
      localTreeColumn.setText(paramArrayOfString1[i]);
      if ((paramArrayOfInt != null) && (i < paramArrayOfInt.length))
        localTreeColumn.setWidth(paramArrayOfInt[i]);
      else
        localTreeColumn.setWidth(100);
      int j = i;
      localTreeColumn.addSelectionListener(new u(this, localTreeColumn, paramArrayOfString2, j));
    }
  }

  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.a.getItemCount() == 0)
      return;
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(Display.getCurrent().getSystemCursor(1));
    TreeItem[] arrayOfTreeItem = this.a.getItems();
    ArrayList localArrayList = new ArrayList(this.a.getItemCount());
    Object localObject;
    for (int i = 0; i < this.a.getItemCount(); i++)
    {
      localObject = new String[this.d];
      for (int j = 0; j < this.d; j++)
        localObject[j] = arrayOfTreeItem[i].getText(j);
      localArrayList.add(localObject);
    }
    for (i = 1; i < localArrayList.size(); i++)
      a(localArrayList, i, paramInt, paramString, paramBoolean);
    this.a.removeAll();
    for (i = 0; i < localArrayList.size(); i++)
    {
      localObject = new TreeItem(this.a, 0);
      ((TreeItem)localObject).setText((String[])localArrayList.get(i));
    }
    if (Display.getCurrent().getActiveShell() != null)
      Display.getCurrent().getActiveShell().setCursor(null);
  }

  private void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    String[] arrayOfString1 = (String[])paramArrayList.get(paramInt1);
    paramArrayList.remove(paramInt1);
    for (int i = 0; i < paramInt1; i++)
    {
      String[] arrayOfString2 = (String[])paramArrayList.get(i);
      if (!a(arrayOfString2[paramInt2], arrayOfString1[paramInt2], paramString, paramBoolean))
        continue;
      paramArrayList.add(i, arrayOfString1);
      return;
    }
    paramArrayList.add(paramInt1, arrayOfString1);
  }

  private boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString3.equalsIgnoreCase("int")) || (paramString3.equalsIgnoreCase("double")) || (paramString3.equalsIgnoreCase("float")) || (paramString3.equalsIgnoreCase("long")))
    {
      if ((paramBoolean) && (Double.parseDouble(paramString1) > Double.parseDouble(paramString2)))
        return true;
      return (!paramBoolean) && (Double.parseDouble(paramString1) < Double.parseDouble(paramString2));
    }
    if ((paramString3.equalsIgnoreCase("date")) || (paramString3.equalsIgnoreCase("datetime")) || (paramString3.equalsIgnoreCase("time")))
      try
      {
        if ((paramBoolean) && (Property.getInstance().parseDate(paramString1).after(Property.getInstance().parseDate(paramString2))))
          return true;
        return (!paramBoolean) && (Property.getInstance().parseDate(paramString1).before(Property.getInstance().parseDate(paramString2)));
      }
      catch (ParseException localParseException)
      {
      }
    if ((paramBoolean) && (paramString1.compareTo(paramString2) > 0))
      return true;
    return (!paramBoolean) && (paramString1.compareTo(paramString2) < 0);
  }

  private void g()
  {
    TreeColumn[] arrayOfTreeColumn = this.a.getColumns();
    for (int i = 0; i < arrayOfTreeColumn.length; i++)
      arrayOfTreeColumn[i].setImage(null);
  }

  public void a()
  {
    v localv = new v(this);
    if (localv.open() == 0)
    {
      this.e = localv.a();
      this.g = localv.c();
      this.f = localv.d();
      b();
    }
  }

  public void b()
  {
    if ((this.e == null) || (this.e.length() == 0))
    {
      a();
    }
    else if (this.a.getSelectionCount() > 0)
    {
      TreeItem localTreeItem = this.a.getSelection()[(this.a.getSelectionCount() - 1)];
      if ((localTreeItem.getItemCount() > 0) && ((!this.f) || (localTreeItem.getExpanded())) && (a(localTreeItem.getItems())))
        return;
      a(localTreeItem);
    }
    else
    {
      a(this.a.getItems());
    }
  }

  private boolean a(TreeItem paramTreeItem)
  {
    int i;
    TreeItem[] arrayOfTreeItem;
    int j;
    if (paramTreeItem.getParentItem() != null)
    {
      i = paramTreeItem.getParentItem().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[paramTreeItem.getParentItem().getItemCount() - i - 1];
      for (j = i + 1; j < paramTreeItem.getParentItem().getItemCount(); j++)
        arrayOfTreeItem[(j - i - 1)] = paramTreeItem.getParentItem().getItem(j);
      if (a(arrayOfTreeItem))
        return true;
      if (a(paramTreeItem.getParentItem()))
        return true;
    }
    else if (paramTreeItem.getParent() != null)
    {
      i = paramTreeItem.getParent().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[paramTreeItem.getParent().getItemCount() - i - 1];
      for (j = i + 1; j < paramTreeItem.getParent().getItemCount(); j++)
        arrayOfTreeItem[(j - i - 1)] = paramTreeItem.getParent().getItem(j);
      if (a(arrayOfTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TreeItem paramTreeItem)
  {
    if (this.g < 0)
    {
      for (int i = 0; i < this.a.getColumnCount(); i++)
        if (paramTreeItem.getText(i).indexOf(this.e) >= 0)
          return true;
      return false;
    }
    return paramTreeItem.getText(this.g).indexOf(this.e) >= 0;
  }

  private boolean a(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i = 0; i < paramArrayOfTreeItem.length; i++)
    {
      if (b(paramArrayOfTreeItem[i]))
      {
        if (paramArrayOfTreeItem[i].getParentItem() != null)
          d(paramArrayOfTreeItem[i].getParentItem());
        this.a.setSelection(paramArrayOfTreeItem[i]);
        return true;
      }
      if ((paramArrayOfTreeItem[i].getItemCount() > 0) && ((!this.f) || (paramArrayOfTreeItem[i].getExpanded())) && (a(paramArrayOfTreeItem[i].getItems())))
        return true;
    }
    return false;
  }

  private boolean c(TreeItem paramTreeItem)
  {
    int i;
    TreeItem[] arrayOfTreeItem;
    int j;
    if (paramTreeItem.getParentItem() != null)
    {
      i = paramTreeItem.getParentItem().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[i];
      for (j = 0; j < i; j++)
        arrayOfTreeItem[j] = paramTreeItem.getParentItem().getItem(j);
      if (b(arrayOfTreeItem))
        return true;
      if (c(paramTreeItem.getParentItem()))
        return true;
    }
    else if (paramTreeItem.getParent() != null)
    {
      i = paramTreeItem.getParent().indexOf(paramTreeItem);
      arrayOfTreeItem = new TreeItem[i];
      for (j = 0; j < i; j++)
        arrayOfTreeItem[j] = paramTreeItem.getParent().getItem(j);
      if (b(arrayOfTreeItem))
        return true;
    }
    return false;
  }

  private boolean b(TreeItem[] paramArrayOfTreeItem)
  {
    for (int i = paramArrayOfTreeItem.length - 1; i >= 0; i--)
    {
      if ((paramArrayOfTreeItem[i].getItemCount() > 0) && ((!this.f) || (paramArrayOfTreeItem[i].getExpanded())) && (a(paramArrayOfTreeItem[i].getItems())))
        return true;
      if (!b(paramArrayOfTreeItem[i]))
        continue;
      if (paramArrayOfTreeItem[i].getParentItem() != null)
        d(paramArrayOfTreeItem[i].getParentItem());
      this.a.setSelection(paramArrayOfTreeItem[i]);
      return true;
    }
    return false;
  }

  public void c()
  {
    if ((this.e != null) && (this.e.length() > 0))
      if (this.a.getSelectionCount() > 0)
      {
        TreeItem localTreeItem = this.a.getSelection()[(this.a.getSelectionCount() - 1)];
        c(localTreeItem);
      }
      else
      {
        b(this.a.getItems());
      }
  }

  private String[] h()
  {
    String[] arrayOfString = new String[this.a.getColumnCount()];
    for (int i = 0; i < this.a.getColumnCount(); i++)
      arrayOfString[i] = this.a.getColumn(i).getText();
    return arrayOfString;
  }

  void d()
  {
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
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }

  private Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet("tree");
    this.h = 2;
    Row localRow = localSheet.createRow(this.h++);
    TreeColumn[] arrayOfTreeColumn = this.a.getColumns();
    for (int i = 0; i < arrayOfTreeColumn.length; i++)
    {
      Cell localCell = localRow.createCell(i);
      localCell.setCellValue(arrayOfTreeColumn[i].getText());
    }
    a(localSheet, this.a.getItems());
    return paramWorkbook;
  }

  private void a(Sheet paramSheet, TreeItem[] paramArrayOfTreeItem)
  {
    for (int i = 0; i < paramArrayOfTreeItem.length; i++)
    {
      Row localRow = paramSheet.createRow(this.h++);
      for (int j = 0; j < this.a.getColumnCount(); j++)
      {
        Cell localCell = localRow.createCell((short)j);
        String str1 = paramArrayOfTreeItem[i].getText(j);
        if (paramArrayOfTreeItem[i].getData(String.valueOf(j)) != null)
          str1 = (String)paramArrayOfTreeItem[i].getData(String.valueOf(j));
        String str2 = "";
        if (j == 0)
        {
          int k = 0;
          for (k = str1.indexOf("."); k != -1; k = str1.indexOf(".", k + 1))
            str2 = str2 + "    ";
          str1 = str2 + str1;
        }
        localCell.setCellValue(str1);
      }
      if (paramArrayOfTreeItem[i].getItemCount() <= 0)
        continue;
      a(paramSheet, paramArrayOfTreeItem[i].getItems());
    }
  }

  private void d(TreeItem paramTreeItem)
  {
    paramTreeItem.setExpanded(true);
    if (paramTreeItem.getParentItem() != null)
      d(paramTreeItem.getParentItem());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.s
 * JD-Core Version:    0.6.0
 */