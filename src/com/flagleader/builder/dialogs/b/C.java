package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class C extends r
{
  protected SheetTable a = null;
  private i b = new i(true, true);
  private List c = null;
  private Text d;
  private Text e;
  private String f = "";
  private String g = "";
  private String h = "";
  private Table i;

  public C(Shell paramShell, SheetTable paramSheetTable)
  {
    super(paramShell);
    this.a = paramSheetTable;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.SelectSheetFieldsDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(3));
    a(localComposite3, a("matchExcel.SelectSheetFieldsDialog"));
    this.d = a(localComposite3, 2048, 380, 10);
    this.d.setEnabled(true);
    this.d.setText(this.a.getExcelFile());
    Button localButton = new Button(localComposite3, 8);
    localButton.setText(ResourceTools.getMessage("browse"));
    localButton.addSelectionListener(new D(this));
    localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(3));
    a(localComposite3, a("exportExcel.SelectSheetFieldsDialog"));
    this.e = a(localComposite3, 2048, 380, 10);
    this.e.setEnabled(true);
    this.e.setText("");
    localButton = new Button(localComposite3, 8);
    localButton.setText(ResourceTools.getMessage("browse"));
    localButton.addSelectionListener(new E(this));
    this.i = this.b.a(localComposite2, 67618);
    this.i.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectSheetFieldsDialog");
    while (this.i.getColumnCount() > 0)
      this.i.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int j = 0; j < arrayOfString1.length; j++)
    {
      arrayOfString2[j] = ResourceTools.getMessage(arrayOfString1[j] + ".SelectSheetFieldsDialog");
      arrayOfInt[j] = 160;
      arrayOfString3[j] = "string";
    }
    this.b.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.i.setHeaderVisible(true);
    this.i.setLayoutData(new GridData(1808));
    List localList1 = this.a.getSelectedElements();
    List localList2 = this.a.getFields();
    for (int k = 0; (localList2 != null) && (k < localList2.size()); k++)
    {
      TableItem localTableItem = new TableItem(this.i, 0);
      localTableItem.setData(localList2.get(k));
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList2.get(k);
      a(localTableItem, localSheetFieldModel.getDisplayName(), localSheetFieldModel.getValueName(), localSheetFieldModel.getValueType());
      for (int m = 0; m < localList1.size(); m++)
      {
        if (!localSheetFieldModel.equals(localList1.get(m)))
          continue;
        localTableItem.setChecked(true);
        break;
      }
    }
    this.i.addSelectionListener(new F(this));
    for (k = 0; k < this.i.getColumnCount(); k++)
      this.i.getColumn(k).pack();
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
    TableItem[] arrayOfTableItem = this.i.getItems();
    this.c = new ArrayList();
    for (int j = 0; j < arrayOfTableItem.length; j++)
    {
      if (!arrayOfTableItem[j].getChecked())
        continue;
      this.c.add(arrayOfTableItem[j].getData());
      this.f = (this.f + "," + j);
    }
    if (this.c.size() <= 0)
    {
      MessageDialog.openError(getShell(), "", a("error.SelectSheetFieldsDialog"));
      return;
    }
    this.g = this.d.getText();
    if (!new File(this.g).exists())
    {
      MessageDialog.openError(getShell(), "", c.a("matchExcelExits.SelectSheetFieldsDialog", new String[] { this.g }));
      return;
    }
    this.h = this.e.getText();
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

  public String b()
  {
    if (this.f.length() > 0)
      return this.f.substring(1);
    return "";
  }

  public String c()
  {
    return this.g;
  }

  public String d()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.C
 * JD-Core Version:    0.6.0
 */