package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.rlm.editen.ISheetFieldEditen;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class bA extends r
{
  protected ISheetFieldEditen a = null;
  private i b = new i(true, true);
  private IBusinessObject c = null;
  private Table d;

  public bA(Shell paramShell, ISheetFieldEditen paramISheetFieldEditen)
  {
    super(paramShell);
    this.a = paramISheetFieldEditen;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.SelectSheetFieldDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    this.d = this.b.a(localComposite2, 67618);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectSheetFieldDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectSheetFieldDialog");
      arrayOfInt[i] = 160;
      arrayOfString3[i] = "string";
    }
    this.b.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.d.setHeaderVisible(true);
    this.d.setLayoutData(new GridData(1808));
    IBusinessObject[] arrayOfIBusinessObject = this.a.getSelects();
    for (int j = 0; (arrayOfIBusinessObject != null) && (j < arrayOfIBusinessObject.length); j++)
    {
      TableItem localTableItem = new TableItem(this.d, 0);
      localTableItem.setData(arrayOfIBusinessObject[j]);
      a(localTableItem, arrayOfIBusinessObject[j].getDisplayName(), arrayOfIBusinessObject[j].getValueName(), arrayOfIBusinessObject[j].getValueType());
      if (!arrayOfIBusinessObject[j].equals(this.a.getSelected()))
        continue;
      localTableItem.setChecked(true);
    }
    this.d.addSelectionListener(new bB(this));
    for (j = 0; j < this.d.getColumnCount(); j++)
      this.d.getColumn(j).pack();
    return localComposite1;
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(2, paramString3);
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.d.getItems();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.c = ((IBusinessObject)arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
  }

  public IBusinessObject a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bA
 * JD-Core Version:    0.6.0
 */