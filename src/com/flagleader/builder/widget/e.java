package com.flagleader.builder.widget;

import com.flagleader.engine.IRuleLog;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.I;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class e
{
  private Tree b = null;
  String[] a = new String[0];

  public Tree a(Composite paramComposite, int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    this.b = new s().a(paramComposite, paramInt);
    this.b.setLayoutData(new GridData(1808));
    this.b.setHeaderVisible(true);
    this.b.setLinesVisible(true);
    this.b.addMouseListener(new f(this));
    return this.b;
  }

  public void a(IRuleLog paramIRuleLog, IRulePackage paramIRulePackage)
  {
    List localList = paramIRulePackage.getEnvionment().getRelateVarNames();
    this.a = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      this.a[i] = ((IVariableObject)localList.get(i)).getDisplayName();
    this.b.removeAll();
    while (this.b.getColumnCount() > 0)
      this.b.getColumn(0).dispose();
    TreeColumn localTreeColumn = new TreeColumn(this.b, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(c.b("rulename.RuleLogViewer"));
    localTreeColumn = new TreeColumn(this.b, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(c.b("condition.RuleLogViewer"));
    for (int j = 0; j < localList.size(); j++)
    {
      localTreeColumn = new TreeColumn(this.b, 8388608);
      localTreeColumn.setText(((IVariableObject)localList.get(j)).getDisplayName());
      localTreeColumn.setWidth(80);
      localTreeColumn.setMoveable(true);
      int k = j + 2;
      localTreeColumn.addSelectionListener(new g(this, k));
    }
    a(paramIRuleLog);
  }

  private void a(TreeItem paramTreeItem, int paramInt)
  {
    for (int i = 0; i < paramTreeItem.getItemCount(); i++)
    {
      if (paramTreeItem.getItems()[i].getItemCount() > 0)
        a(paramTreeItem.getItem(i), paramInt);
      if (!paramTreeItem.getItems()[i].getForeground(paramInt).equals(h.g))
        continue;
      paramTreeItem.getItems()[i].getParentItem().setExpanded(true);
    }
  }

  private void a(IRuleLog paramIRuleLog)
  {
    TreeItem localTreeItem = new TreeItem(this.b, 0);
    if (paramIRuleLog.getRuleName() != null)
      localTreeItem.setText(0, paramIRuleLog.getRuleName());
    String str1 = paramIRuleLog.getRuleProcess();
    if (str1 == null)
      str1 = "";
    if (str1.length() > 20)
    {
      localTreeItem.setData(String.valueOf(1), str1);
      localTreeItem.setText(1, str1.substring(0, 20) + "...");
    }
    else
    {
      localTreeItem.setText(1, str1);
    }
    for (int i = 0; i < this.a.length; i++)
    {
      String str2 = paramIRuleLog.getInitValue(this.a[i]);
      String str3 = paramIRuleLog.getResultValue(this.a[i]);
      if (str2 == null)
      {
        localTreeItem.setText(i + 2, StringUtil.stringValue(str3));
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        localTreeItem.setText(i + 2, str2);
      }
      else
      {
        localTreeItem.setForeground(i + 2, h.g);
        localTreeItem.setText(i + 2, str2 + " - " + str3);
      }
    }
    if (paramIRuleLog.hasChild())
      for (i = 0; i < paramIRuleLog.getChildRules().size(); i++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(i));
    localTreeItem.setExpanded(true);
    this.b.update();
  }

  private void a(TreeItem paramTreeItem, IRuleLog paramIRuleLog)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setText(0, paramIRuleLog.getRuleName());
    String str1 = paramIRuleLog.getRuleProcess();
    if (str1 == null)
      str1 = "";
    if (str1.length() > 20)
    {
      localTreeItem.setData(String.valueOf(1), str1);
      localTreeItem.setText(1, str1.substring(0, 20) + "...");
    }
    else
    {
      localTreeItem.setText(1, str1);
    }
    for (int i = 0; i < this.a.length; i++)
    {
      String str2 = paramIRuleLog.getInitValue(this.a[i]);
      String str3 = paramIRuleLog.getResultValue(this.a[i]);
      if (str2 == null)
      {
        localTreeItem.setText(i + 2, StringUtil.stringValue(str3));
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        localTreeItem.setText(i + 2, str2);
      }
      else
      {
        localTreeItem.setForeground(i + 2, h.g);
        localTreeItem.setText(i + 2, str2 + " - " + str3);
      }
    }
    if (paramIRuleLog.hasChild())
      for (i = 0; i < paramIRuleLog.getChildRules().size(); i++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(i));
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.e
 * JD-Core Version:    0.6.0
 */