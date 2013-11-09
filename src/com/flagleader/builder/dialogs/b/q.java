package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class q extends r
{
  private List a = null;
  private List b = new ArrayList();
  private i c = new i(true, true);
  private Combo d;
  private Text e;
  private String f = "html";
  private String g = "";
  private static String[] h = { "html", "pages", "jhtml", "jquery", "sheet", "xytable", "newhtml", "newpages", "sheetjquery", "sheetnew", "sheethtml" };
  private static String[] i = new String[h.length];
  private Table j;

  static
  {
    for (int k = 0; k < h.length; k++)
      i[k] = ResourceTools.getMessage(h[k] + ".template");
  }

  public q(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.a = paramList;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadTableDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(2));
    a(localComposite3).setText(a("packagename.LoadHtmlTableDialog"));
    this.e = a(localComposite3, 2048, 380, 12);
    this.d = a(localComposite3, a("html.LoadHtmlTableDialog"), 2048, 280, 12, 2);
    this.d.setItems(i);
    this.d.setVisibleItemCount(this.d.getItemCount());
    this.d.select(0);
    this.j = this.c.a(localComposite2, 67618);
    this.j.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableDialog");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int k = 0; k < arrayOfString1.length; k++)
    {
      arrayOfString2[k] = ResourceTools.getMessage(arrayOfString1[k] + ".LoadTableDialog");
      arrayOfInt[k] = 150;
      arrayOfString3[k] = "string";
    }
    this.c.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.j.setHeaderVisible(true);
    this.j.setLayoutData(new GridData(1808));
    for (k = 0; k < this.a.size(); k++)
    {
      TableItem localTableItem = new TableItem(this.j, 0);
      ISelectObject localISelectObject = (ISelectObject)this.a.get(k);
      localTableItem.setData(localISelectObject);
      a(localTableItem, localISelectObject.getMainTableName(), localISelectObject.getDisplayName(), a(localISelectObject));
    }
    for (k = 0; k < this.j.getColumnCount(); k++)
      this.j.getColumn(k).pack();
    return localComposite1;
  }

  private String a(ISelectObject paramISelectObject)
  {
    if (paramISelectObject.getFields().size() < 1)
      return "";
    String str = "";
    for (int k = 0; k < paramISelectObject.getFields().size(); k++)
      str = str + ((FieldModel)paramISelectObject.getFields().get(k)).getDisplayName() + "   ";
    return str;
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(2, paramString3);
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.j.getItems();
    this.b.clear();
    for (int k = 0; k < arrayOfTableItem.length; k++)
    {
      if ((!arrayOfTableItem[k].getChecked()) || (arrayOfTableItem[k].getData() == null))
        continue;
      this.b.add(arrayOfTableItem[k].getData());
    }
    if (this.d.getSelectionIndex() >= 0)
      this.f = h[this.d.getSelectionIndex()];
    else
      this.f = this.d.getText();
    this.g = this.e.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.g;
  }

  public List b()
  {
    return this.b;
  }

  public String c()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.q
 * JD-Core Version:    0.6.0
 */