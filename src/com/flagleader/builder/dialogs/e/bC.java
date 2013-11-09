package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class bC extends r
{
  protected ISheetFieldsSelectEditen a = null;
  private i b = new i(true, true);
  private List c = null;
  private Table d;

  public bC(Shell paramShell, ISheetFieldsSelectEditen paramISheetFieldsSelectEditen)
  {
    super(paramShell);
    this.a = paramISheetFieldsSelectEditen;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.SelectSheetFieldsDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 350));
    this.d = this.b.a(localComposite2, 67618);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectSheetFieldsDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectSheetFieldsDialog");
      arrayOfInt[i] = 150;
      arrayOfString3[i] = "string";
    }
    this.b.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.d.setHeaderVisible(true);
    this.d.setLayoutData(new GridData(1808));
    List localList = this.a.getSelectedElements();
    IBusinessObject[] arrayOfIBusinessObject = this.a.getSelects();
    for (int j = 0; (arrayOfIBusinessObject != null) && (j < arrayOfIBusinessObject.length); j++)
    {
      TableItem localTableItem = new TableItem(this.d, 0);
      localTableItem.setData(arrayOfIBusinessObject[j]);
      a(localTableItem, arrayOfIBusinessObject[j].getDisplayName(), arrayOfIBusinessObject[j].getValueName(), arrayOfIBusinessObject[j].getValueType());
      for (int k = 0; k < localList.size(); k++)
      {
        if ((localList.get(k) == null) || (!arrayOfIBusinessObject[j].equals(localList.get(k))))
          continue;
        localTableItem.setChecked(true);
        break;
      }
    }
    this.d.addSelectionListener(new bD(this));
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
    this.c = new ArrayList();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.c.add(arrayOfTableItem[i].getData());
    }
    if (this.c.size() < 0)
    {
      MessageDialog.openError(getShell(), "", a("error.SelectSheetFieldsDialog"));
      return;
    }
    super.okPressed();
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
  }

  public List a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bC
 * JD-Core Version:    0.6.0
 */