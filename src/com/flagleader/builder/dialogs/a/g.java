package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class g extends r
{
  private List a = null;
  private List b = new ArrayList();
  private Table c;

  public g(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.a = paramList;
    super.setShellStyle(66576);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddSubFunctionDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    GridData localGridData = new GridData(750, 500);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    i locali = new i(false, true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.AddSubFunctionDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.AddSubFunctionDialo");
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfInt[i] = Integer.parseInt(arrayOfString2[i]);
      arrayOfString3[i] = "string";
      if (ResourceTools.getMessage(arrayOfString1[i] + ".AddSubFunctionDialog") == null)
        continue;
      arrayOfString1[i] = ResourceTools.getMessage(arrayOfString1[i] + ".AddSubFunctionDialog");
    }
    this.c = locali.a(localComposite2, 67618);
    locali.a(arrayOfString1, arrayOfInt, arrayOfString3);
    this.c.setLinesVisible(true);
    this.c.setHeaderVisible(true);
    this.c.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.size(); i++)
    {
      TableItem localTableItem = new TableItem(this.c, 0);
      IBusinessObject localIBusinessObject = (IBusinessObject)this.a.get(i);
      localTableItem.setData(localIBusinessObject);
      a(localTableItem, localIBusinessObject, localIBusinessObject.isVisible());
    }
    this.c.addMouseListener(new h(this));
    return localComposite1;
  }

  private void a(TableItem paramTableItem, IBusinessObject paramIBusinessObject, boolean paramBoolean)
  {
    paramTableItem.setText(2, paramIBusinessObject.getValueName());
    paramTableItem.setText(1, paramIBusinessObject.getValueType());
    paramTableItem.setText(0, paramIBusinessObject.getDisplayName());
    paramTableItem.setText(3, paramIBusinessObject.getVarValue());
    paramTableItem.setChecked(paramBoolean);
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.c.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.b.add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.g
 * JD-Core Version:    0.6.0
 */