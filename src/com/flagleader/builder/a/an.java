package com.flagleader.builder.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.builder.a.c.g;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.builder.widget.p;
import com.flagleader.manager.d.c;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public abstract class an extends aS
{
  protected Table e;
  public static final int f = 0;
  public static final int g = 1;
  private String q = "";
  private int r = 0;
  private int s = 0;

  public an(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    Table localTable = b(localComposite);
    localTable.setData(this.c);
    i();
    j();
    return localComposite;
  }

  public void update()
  {
    if (!e())
      return;
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    this.e.update();
    k();
    for (i = 0; i < this.e.getColumnCount(); i++)
      this.e.getColumn(i).pack();
    super.update();
  }

  protected boolean e()
  {
    return (this.b != null) && (!this.b.isDisposed()) && ((this.a == null) || (equals(this.a.e())));
  }

  protected boolean f()
  {
    return false;
  }

  protected boolean g()
  {
    return false;
  }

  protected boolean a(IElement paramIElement, boolean paramBoolean)
  {
    return true;
  }

  protected void h()
  {
    a(new av(this));
    super.h();
  }

  protected abstract void i();

  protected void a(TableItem paramTableItem, int paramInt, f paramf)
  {
    Text localText = new p(a()).a(this.e, 4);
    localText.setFont(this.e.getFont());
    localText.setText(paramf.a());
    a(paramTableItem, localText, paramInt, paramf);
    localText.setFocus();
  }

  protected void j()
  {
    if (!b())
    {
      this.e.addKeyListener(new ao(this));
      this.e.addMouseMoveListener(new ap(this));
      if (f())
        this.e.addSelectionListener(new aq(this));
    }
  }

  protected Table b(Composite paramComposite)
  {
    int i = 67586;
    if (f())
      i |= 32;
    if (g())
      this.e = new i(false, true).a(paramComposite, i);
    else
      this.e = new Table(paramComposite, i);
    this.e.setLinesVisible(true);
    this.e.setLayoutData(new GridData(1808));
    return this.e;
  }

  private void a(TableItem paramTableItem, Text paramText, int paramInt, f paramf)
  {
    paramText.selectAll();
    TableEditor localTableEditor = new TableEditor(this.e);
    localTableEditor.horizontalAlignment = 16384;
    localTableEditor.grabHorizontal = true;
    localTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new ar(this, paramTableItem, paramText, paramInt, paramf, localTableEditor));
    paramText.addTraverseListener(new as(this, paramTableItem, paramText, paramInt, paramf, localTableEditor));
  }

  private void a(TableItem paramTableItem, Text paramText, int paramInt, f paramf, TableEditor paramTableEditor)
  {
    if ((!paramTableItem.isDisposed()) && (!paramText.isDisposed()) && (!b()) && (!paramf.a().equals(paramText.getText())))
    {
      paramf.a(paramText.getText());
      paramTableItem.setText(paramInt, paramText.getText());
      a(paramTableItem);
    }
    a(paramText, paramTableEditor);
  }

  private void a(Control paramControl, TableEditor paramTableEditor)
  {
    paramTableEditor.setEditor(null, null, -1);
    paramTableEditor.dispose();
    if (paramControl != null)
    {
      paramControl.dispose();
      paramControl = null;
    }
  }

  protected void a(TableItem paramTableItem, int paramInt, g paramg)
  {
    CCombo localCCombo = new CCombo(this.e, 0);
    localCCombo.setBackground(h.d);
    localCCombo.setFocus();
    localCCombo.setItems(paramg.b());
    localCCombo.setText(paramg.a());
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    a(paramTableItem, localCCombo, paramInt, paramg);
    localCCombo.setFocus();
  }

  void a(TableItem paramTableItem, CCombo paramCCombo, int paramInt, g paramg)
  {
    TableEditor localTableEditor = new TableEditor(this.e);
    localTableEditor.horizontalAlignment = 16384;
    localTableEditor.grabHorizontal = true;
    localTableEditor.minimumWidth = 50;
    localTableEditor.setEditor(paramCCombo, paramTableItem, paramInt);
    paramCCombo.addFocusListener(new at(this, paramg, paramCCombo, paramTableItem, paramInt, localTableEditor));
    paramCCombo.addTraverseListener(new au(this, paramg, paramCCombo, paramTableItem, paramInt, localTableEditor));
  }

  protected abstract void a(TableItem paramTableItem);

  protected abstract void k();

  public boolean isCanFind()
  {
    return true;
  }

  public void find()
  {
    aw localaw = new aw(this);
    if (localaw.open() == 0)
    {
      this.q = localaw.a();
      this.r = localaw.c();
      findNext();
    }
  }

  public void findNext()
  {
    if ((this.q == null) || (this.q.length() == 0))
    {
      find();
    }
    else if (this.e.getSelectionCount() > 0)
    {
      TableItem localTableItem = this.e.getSelection()[(this.e.getSelectionCount() - 1)];
      b(localTableItem);
    }
    else
    {
      a(this.e.getItems());
    }
  }

  private boolean b(TableItem paramTableItem)
  {
    if (paramTableItem.getParent() != null)
    {
      int i = paramTableItem.getParent().indexOf(paramTableItem);
      TableItem[] arrayOfTableItem = new TableItem[paramTableItem.getParent().getItemCount() - i - 1];
      for (int j = i + 1; j < paramTableItem.getParent().getItemCount(); j++)
        arrayOfTableItem[(j - i - 1)] = paramTableItem.getParent().getItem(j);
      if (a(arrayOfTableItem))
        return true;
    }
    return false;
  }

  private boolean c(TableItem paramTableItem)
  {
    if (this.r < 0)
    {
      for (int i = 0; i < this.e.getColumnCount(); i++)
        if (paramTableItem.getText(i).indexOf(this.q) >= 0)
          return true;
      return false;
    }
    return paramTableItem.getText(this.r).indexOf(this.q) >= 0;
  }

  private boolean a(TableItem[] paramArrayOfTableItem)
  {
    for (int i = 0; i < paramArrayOfTableItem.length; i++)
    {
      if (!c(paramArrayOfTableItem[i]))
        continue;
      this.e.setSelection(new TableItem[] { paramArrayOfTableItem[i] });
      return true;
    }
    return false;
  }

  private boolean d(TableItem paramTableItem)
  {
    if (paramTableItem.getParent() != null)
    {
      int i = paramTableItem.getParent().indexOf(paramTableItem);
      TableItem[] arrayOfTableItem = new TableItem[i];
      for (int j = 0; j < i; j++)
        arrayOfTableItem[j] = paramTableItem.getParent().getItem(j);
      if (b(arrayOfTableItem))
        return true;
    }
    return false;
  }

  private boolean b(TableItem[] paramArrayOfTableItem)
  {
    for (int i = paramArrayOfTableItem.length - 1; i >= 0; i--)
    {
      if (!c(paramArrayOfTableItem[i]))
        continue;
      this.e.setSelection(new TableItem[] { paramArrayOfTableItem[i] });
      return true;
    }
    return false;
  }

  public void l()
  {
    if ((this.q != null) && (this.q.length() > 0))
      if (this.e.getSelectionCount() > 0)
      {
        TableItem localTableItem = this.e.getSelection()[(this.e.getSelectionCount() - 1)];
        d(localTableItem);
      }
      else
      {
        b(this.e.getItems());
      }
  }

  protected IElement[] m()
  {
    if (this.e.getSelectionCount() > 0)
    {
      IElement[] arrayOfIElement = new IElement[this.e.getSelectionCount()];
      TableItem[] arrayOfTableItem = this.e.getSelection();
      for (int i = 0; i < arrayOfTableItem.length; i++)
      {
        if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof IElement)))
          continue;
        arrayOfIElement[i] = ((IElement)arrayOfTableItem[i].getData());
      }
      return arrayOfIElement;
    }
    return null;
  }

  public void copy()
  {
    if (this.e.getSelectionCount() <= 0)
      return;
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = m();
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IElement)) || (!arrayOfIElement[i].getParent().equals(this.c)))
        continue;
      localElementContainer.addChildElement(arrayOfIElement[i]);
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
  }

  public void selectAll()
  {
    this.e.setSelection(this.e.getItems());
    setChanged();
    notifyObservers();
  }

  private String[] q()
  {
    String[] arrayOfString = new String[this.e.getColumnCount()];
    for (int i = 0; i < this.e.getColumnCount(); i++)
      arrayOfString[i] = this.e.getColumn(i).getText();
    return arrayOfString;
  }

  protected int n()
  {
    return 0;
  }

  protected void o()
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

  protected Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet(this.c.getDisplayName());
    this.s = 0;
    Row localRow = localSheet.createRow(this.s++);
    TableColumn[] arrayOfTableColumn = this.e.getColumns();
    for (int i = n(); i < arrayOfTableColumn.length; i++)
    {
      Cell localCell = localRow.createCell(i - n());
      localCell.setCellValue(arrayOfTableColumn[i].getText());
    }
    localSheet.createFreezePane(0, 1, 0, 1);
    a(localSheet, this.e.getItems());
    return paramWorkbook;
  }

  protected void a(Sheet paramSheet, TableItem[] paramArrayOfTableItem)
  {
    for (int i = 0; i < paramArrayOfTableItem.length; i++)
    {
      Row localRow = paramSheet.createRow(this.s++);
      for (int j = n(); j < this.e.getColumnCount(); j++)
      {
        Cell localCell = localRow.createCell(j - n());
        String str = paramArrayOfTableItem[i].getText(j);
        localCell.setCellValue(str);
      }
    }
  }

  protected boolean p()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.an
 * JD-Core Version:    0.6.0
 */