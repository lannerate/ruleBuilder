package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.a.a.c;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class j extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private i b = new i(true, true);
  private IRuleProject c;
  private Button d;
  private Button e;
  private List f;
  private BuilderManager g;
  private int h = 0;
  private Button i;
  private boolean j = false;
  private Table k;

  public j(BuilderManager paramBuilderManager, IRuleProject paramIRuleProject, int paramInt)
  {
    super(paramBuilderManager.getShell());
    this.c = paramIRuleProject;
    this.g = paramBuilderManager;
    this.h = paramInt;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.LoadFromRuleServerDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    GridData localGridData = new GridData(860, 550);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    this.k = this.b.a(localComposite2, 67618);
    this.k.setLinesVisible(true);
    this.f = c();
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.LoadFromRuleServerDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.LoadFromRuleServerDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.LoadFromRuleServerDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int m = 0; m < arrayOfString3.length; m++)
      arrayOfInt[m] = Integer.parseInt(arrayOfString3[m]);
    for (m = 0; m < arrayOfString1.length; m++)
      arrayOfString1[m] = a(arrayOfString1[m] + ".LoadFromRuleServerDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.k.setHeaderVisible(true);
    this.k.setLayoutData(new GridData(1808));
    for (m = 0; (this.f != null) && (m < this.f.size()); m++)
    {
      List localList = (List)this.f.get(m);
      if (!localList.get(3).toString().equalsIgnoreCase(this.c.getDisplayName()))
        continue;
      TableItem localTableItem = new TableItem(this.k, 0);
      localTableItem.setData(localList);
      a(localTableItem, localList);
      RulePackage localRulePackage = this.c.exitsPackage(localList.get(2).toString());
      if (localRulePackage != null)
        continue;
      localTableItem.setChecked(true);
    }
    this.d = new Button(localComposite1, 32);
    this.d.setText(a("viewall.LoadFromRuleServerDialog"));
    this.d.addSelectionListener(new k(this));
    Button localButton = new Button(localComposite1, 32);
    localButton.setText(a("selectall.dialog"));
    localButton.addSelectionListener(new l(this, localButton));
    this.i = new Button(localComposite2, 32);
    this.i.setText(a("lockcheckout.RulePackageProperties"));
    return localComposite1;
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int m = 0; m < paramList.size(); m++)
      if (paramList.get(m) == null)
        paramTableItem.setText(m, "");
      else
        paramTableItem.setText(m, StringUtil.stringValue(paramList.get(m)));
    paramTableItem.setData(paramList);
  }

  private List c()
  {
    try
    {
      c localc = this.g.getRulesManager().p();
      List localList = localc.a(this.h);
      if (localList == null)
      {
        MessageDialog.openError(getShell(), "", localc.i());
        return Collections.EMPTY_LIST;
      }
      return localList;
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
    }
    return Collections.EMPTY_LIST;
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.k.getItems();
    this.a.clear();
    for (int m = 0; m < arrayOfTableItem.length; m++)
    {
      if (!arrayOfTableItem[m].getChecked())
        continue;
      this.a.add(arrayOfTableItem[m].getData());
    }
    if (this.a.size() < 1)
    {
      MessageDialog.openError(getShell(), "", "nothing select");
      return;
    }
    this.j = this.i.getSelection();
    super.okPressed();
  }

  public boolean a()
  {
    return this.j;
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public List b()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.j
 * JD-Core Version:    0.6.0
 */