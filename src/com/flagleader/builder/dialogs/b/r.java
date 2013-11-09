package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
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

public class r extends com.flagleader.builder.dialogs.r
{
  private List a = null;
  private List b = new ArrayList();
  private i c = new i(true, true);
  private Combo d;
  private Text e;
  private String f = "tree";
  private String g = "";
  private Table h;

  public r(Shell paramShell, List paramList)
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
    this.d.setItems(new String[] { "tree", "jtree" });
    this.d.setText(this.f);
    this.h = this.c.a(localComposite2, 67618);
    this.h.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.LoadTableDialog");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".LoadTableDialog");
      arrayOfInt[i] = 150;
      arrayOfString3[i] = "string";
    }
    this.c.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.h.setHeaderVisible(true);
    this.h.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.size(); i++)
    {
      TableItem localTableItem = new TableItem(this.h, 0);
      ISelectObject localISelectObject = (ISelectObject)this.a.get(i);
      localTableItem.setData(localISelectObject);
      a(localTableItem, localISelectObject.getMainTableName(), localISelectObject.getDisplayName(), a(localISelectObject));
    }
    for (i = 0; i < this.h.getColumnCount(); i++)
      this.h.getColumn(i).pack();
    return localComposite1;
  }

  private String a(ISelectObject paramISelectObject)
  {
    if (paramISelectObject.getFields().size() < 1)
      return "";
    String str = "";
    for (int i = 0; i < paramISelectObject.getFields().size(); i++)
      str = str + ((FieldModel)paramISelectObject.getFields().get(i)).getDisplayName() + "   ";
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
    TableItem[] arrayOfTableItem = this.h.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((!arrayOfTableItem[i].getChecked()) || (arrayOfTableItem[i].getData() == null))
        continue;
      this.b.add(arrayOfTableItem[i].getData());
    }
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
 * Qualified Name:     com.flagleader.builder.dialogs.b.r
 * JD-Core Version:    0.6.0
 */