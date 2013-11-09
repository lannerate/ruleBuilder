package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.a.a.c;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.DateUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class C extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private List b = new ArrayList();
  private i c = new i(true, true);
  private i d = new i(true, true);
  private IRuleGroup e;
  private BuilderManager f;
  private int g = 0;

  public C(BuilderManager paramBuilderManager, IRuleGroup paramIRuleGroup, int paramInt)
  {
    super(paramBuilderManager.getShell());
    this.e = paramIRuleGroup;
    this.f = paramBuilderManager;
    this.g = paramInt;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RuleSynchronizeDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    GridData localGridData = new GridData(860, 600);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    SashForm localSashForm = new SashForm(localComposite2, 512);
    localSashForm.setLayout(h.a(1));
    localSashForm.setLayoutData(new GridData(1808));
    Composite localComposite3 = new Composite(localSashForm, 2048);
    localComposite3.setBackground(h.d);
    localComposite3.setLayout(h.a(1));
    localComposite3.setLayoutData(new GridData(1808));
    a(localComposite3).setText(a("open.RuleSynchronizeDialog"));
    Table localTable = this.c.a(localComposite3, 67618);
    localTable.setLinesVisible(true);
    List localList1 = c();
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.RuleLoadSelectDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.RuleLoadSelectDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.RuleLoadSelectDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = a(arrayOfString1[i] + ".RuleLoadSelectDialog");
    this.c.a(arrayOfString1, arrayOfInt, arrayOfString2);
    localTable.setHeaderVisible(true);
    localTable.setLayoutData(new GridData(1808));
    Object localObject2;
    for (i = 0; (localList1 != null) && (i < localList1.size()); i++)
    {
      List localList2 = (List)localList1.get(i);
      int k = 0;
      Iterator localIterator2 = this.e.getProject().getRulePackages();
      while (localIterator2.hasNext())
      {
        localObject1 = (RulePackage)localIterator2.next();
        if (!localList2.get(2).toString().equalsIgnoreCase(((RulePackage)localObject1).getExeRulePackageName()))
          continue;
        if ((this.e.exitsPackage(((RulePackage)localObject1).getExeRulePackageName()) != null) && (((RulePackage)localObject1).getMaxModifyTime() + 1000L <= ((Date)localList2.get(5)).getTime()))
        {
          localObject2 = new TableItem(localTable, 0);
          ((TableItem)localObject2).setData(localObject1);
          ((TableItem)localObject2).setText(0, StringUtil.stringValue(localList2.get(0)));
          ((TableItem)localObject2).setText(1, StringUtil.stringValue(localList2.get(1)));
          ((TableItem)localObject2).setText(2, StringUtil.stringValue(localList2.get(2)));
          ((TableItem)localObject2).setText(3, DateUtil.stringDatetime(new Date(((RulePackage)localObject1).getMaxModifyTime())));
          ((TableItem)localObject2).setText(4, ((RulePackage)localObject1).getVersion());
          ((TableItem)localObject2).setText(5, StringUtil.stringValue(localList2.get(5)));
          ((TableItem)localObject2).setText(6, StringUtil.stringValue(localList2.get(8)));
          ((TableItem)localObject2).setText(7, StringUtil.stringValue(localList2.get(6)));
          ((TableItem)localObject2).setText(8, StringUtil.stringValue(localList2.get(7)));
          ((TableItem)localObject2).setChecked(true);
        }
        k = 1;
        break;
      }
      if ((k != 0) || (!localList2.get(3).toString().equalsIgnoreCase(this.e.getProject().getDisplayName())))
        continue;
      Object localObject1 = new TableItem(localTable, 0);
      ((TableItem)localObject1).setData(localList2);
      ((TableItem)localObject1).setText(0, localList2.get(0).toString());
      ((TableItem)localObject1).setText(1, localList2.get(1).toString());
      ((TableItem)localObject1).setText(2, localList2.get(2).toString());
      ((TableItem)localObject1).setText(3, "");
      ((TableItem)localObject1).setText(4, "");
      ((TableItem)localObject1).setText(5, localList2.get(5).toString());
      ((TableItem)localObject1).setText(6, localList2.get(8).toString());
      ((TableItem)localObject1).setText(7, localList2.get(6).toString());
      ((TableItem)localObject1).setText(8, localList2.get(7).toString());
      ((TableItem)localObject1).setChecked(true);
    }
    Composite localComposite4 = new Composite(localSashForm, 2048);
    localComposite4.setBackground(h.d);
    localComposite4.setLayout(h.a(1));
    localComposite4.setLayoutData(new GridData(1808));
    a(localComposite4).setText(a("save.RuleSynchronizeDialog"));
    localTable = this.d.a(localComposite4, 67618);
    localTable.setLinesVisible(true);
    arrayOfString1 = ResourceTools.getStringArray("Columns.RuleLoadSelectDialog");
    arrayOfString2 = ResourceTools.getStringArray("Types.RuleLoadSelectDialog");
    arrayOfString3 = ResourceTools.getStringArray("lengths.RuleLoadSelectDialog");
    arrayOfInt = new int[arrayOfString3.length];
    for (int j = 0; j < arrayOfString3.length; j++)
      arrayOfInt[j] = Integer.parseInt(arrayOfString3[j]);
    for (j = 0; j < arrayOfString1.length; j++)
      arrayOfString1[j] = a(arrayOfString1[j] + ".RuleLoadSelectDialog");
    this.d.a(arrayOfString1, arrayOfInt, arrayOfString2);
    localTable.setHeaderVisible(true);
    localTable.setLayoutData(new GridData(1808));
    Iterator localIterator1 = this.e.getRulePackages();
    while (localIterator1.hasNext())
    {
      RulePackage localRulePackage = (RulePackage)localIterator1.next();
      if (localRulePackage.isLocked())
        continue;
      int m = 0;
      for (int n = 0; (localList1 != null) && (n < localList1.size()); n++)
      {
        localObject2 = (List)localList1.get(n);
        if (!((List)localObject2).get(2).toString().equalsIgnoreCase(localRulePackage.getExeRulePackageName()))
          continue;
        if (localRulePackage.getModifyTime() >= ((Date)((List)localObject2).get(5)).getTime() + 1000L)
        {
          TableItem localTableItem2 = new TableItem(localTable, 0);
          localTableItem2.setData(localRulePackage);
          localTableItem2.setText(0, ((List)localObject2).get(0).toString());
          localTableItem2.setText(1, ((List)localObject2).get(1).toString());
          localTableItem2.setText(2, ((List)localObject2).get(2).toString());
          localTableItem2.setText(3, localRulePackage.getLastModifyTime());
          localTableItem2.setText(4, localRulePackage.getVersion());
          localTableItem2.setText(5, ((List)localObject2).get(5).toString());
          localTableItem2.setText(6, ((List)localObject2).get(8).toString());
          localTableItem2.setText(7, ((List)localObject2).get(6).toString());
          localTableItem2.setText(8, ((List)localObject2).get(7).toString());
          localTableItem2.setChecked(true);
        }
        m = 1;
        break;
      }
      if (m != 0)
        continue;
      TableItem localTableItem1 = new TableItem(localTable, 0);
      localTableItem1.setData(localRulePackage);
      localTableItem1.setText(0, "");
      localTableItem1.setText(1, localRulePackage.getDisplayName());
      localTableItem1.setText(2, localRulePackage.getExeRulePackageName());
      localTableItem1.setText(3, localRulePackage.getLastModifyTime());
      localTableItem1.setText(4, localRulePackage.getVersion());
      localTableItem1.setText(5, "");
      localTableItem1.setText(6, "");
      localTableItem1.setText(7, "");
      localTableItem1.setText(8, "");
      localTableItem1.setChecked(true);
    }
    localSashForm.setWeights(new int[] { 50, 50 });
    return (Control)(Control)localComposite1;
  }

  private List c()
  {
    try
    {
      c localc = this.f.getRulesManager().p();
      List localList = localc.a(this.g);
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
    TableItem[] arrayOfTableItem = this.c.d().getItems();
    this.a.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.a.add(arrayOfTableItem[i].getData());
    }
    arrayOfTableItem = this.d.d().getItems();
    this.b.clear();
    for (i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.b.add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }

  public List b()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.C
 * JD-Core Version:    0.6.0
 */