package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class i extends r
{
  private List a = new ArrayList();
  private List b = null;
  private com.flagleader.builder.widget.i c = new com.flagleader.builder.widget.i(true, true);
  private BuilderManager d = null;
  private Table e;

  public i(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.b = paramList;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ListRuleTemplateDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(860, 550));
    this.e = this.c.a(localComposite2, 67618);
    this.e.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.ListRuleTemplateDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("types.ListRuleTemplateDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ListRuleTemplateDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = a(arrayOfString1[i] + ".ListRuleTemplateDialog");
    this.c.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.e.setHeaderVisible(true);
    this.e.setLayoutData(new GridData(1808));
    for (i = 0; (this.b != null) && (i < this.b.size()); i++)
    {
      TableItem localTableItem = new TableItem(this.e, 0);
      List localList = (List)this.b.get(i);
      localTableItem.setData(localList);
      a(localTableItem, localList);
    }
    return localComposite1;
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      paramTableItem.setText(i, StringUtil.stringValue(paramList.get(i)));
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.e.getItems();
    this.a.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.a.add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.i
 * JD-Core Version:    0.6.0
 */