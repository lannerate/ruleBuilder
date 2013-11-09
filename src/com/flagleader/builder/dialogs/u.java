package com.flagleader.builder.dialogs;

import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.IRuleLog;
import com.flagleader.repository.d.I;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class u extends f
{
  private IRuleLog a = null;
  private RulePackage b = null;
  private s c;
  private List d = null;
  private String[] e = null;
  private Tree f = null;
  private int g = 500;
  private int h = 400;
  private int i = 50;
  private int j = -1;

  public u(IRuleLog paramIRuleLog, RulePackage paramRulePackage)
  {
    super(new Shell());
    this.a = paramIRuleLog;
    this.b = paramRulePackage;
    this.d = this.b.getEnvionment().getRelateVarNames();
    this.e = new String[this.d.size()];
    for (int k = 0; k < this.d.size(); k++)
      this.e[k] = ((IVariableObject)this.d.get(k)).getDisplayName();
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    int k = 8456962;
    localComposite.setLayoutData(new GridData(1808));
    this.c = new s();
    this.f = this.c.a(localComposite, k);
    GridData localGridData = new GridData(this.g, this.h);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.f.setLayoutData(localGridData);
    this.f.addMouseListener(new v(this));
    this.f.removeAll();
    TreeColumn localTreeColumn = new TreeColumn(this.f, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(b("rulename.RuleLogTableDialog"));
    localTreeColumn = new TreeColumn(this.f, 8388608);
    localTreeColumn.setText("");
    localTreeColumn.setWidth(100);
    localTreeColumn.setMoveable(false);
    localTreeColumn.setText(b("condition.RuleLogTableDialog"));
    for (int m = 0; m < this.d.size(); m++)
    {
      localTreeColumn = new TreeColumn(this.f, 8388608);
      localTreeColumn.setText(((IVariableObject)this.d.get(m)).getDisplayName());
      localTreeColumn.setWidth(80);
      localTreeColumn.setMoveable(true);
      int n = m + 2;
      localTreeColumn.addSelectionListener(new w(this, n));
    }
    a(this.a);
    return localComposite;
  }

  private void a(TreeItem paramTreeItem, int paramInt)
  {
    for (int k = 0; k < paramTreeItem.getItemCount(); k++)
    {
      if (paramTreeItem.getItems()[k].getItemCount() > 0)
        a(paramTreeItem.getItem(k), paramInt);
      if (!paramTreeItem.getItems()[k].getForeground(paramInt).equals(h.g))
        continue;
      paramTreeItem.getItems()[k].getParentItem().setExpanded(true);
    }
  }

  private void a(IRuleLog paramIRuleLog)
  {
    TreeItem localTreeItem = new TreeItem(this.f, 0);
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
    for (int k = 0; k < this.d.size(); k++)
    {
      String str2 = paramIRuleLog.getInitValue(this.e[k]);
      String str3 = paramIRuleLog.getResultValue(this.e[k]);
      if (str2 == null)
      {
        localTreeItem.setText(k + 2, StringUtil.stringValue(str3));
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        localTreeItem.setText(k + 2, str2);
      }
      else
      {
        localTreeItem.setForeground(k + 2, h.g);
        localTreeItem.setText(k + 2, str2 + " - " + str3);
      }
    }
    if (paramIRuleLog.hasChild())
      for (k = 0; k < paramIRuleLog.getChildRules().size(); k++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(k));
    localTreeItem.setExpanded(true);
    this.f.update();
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
    for (int k = 0; k < this.d.size(); k++)
    {
      String str2 = paramIRuleLog.getInitValue(this.e[k]);
      String str3 = paramIRuleLog.getResultValue(this.e[k]);
      if (str2 == null)
      {
        localTreeItem.setText(k + 2, StringUtil.stringValue(str3));
      }
      else if ((str3 == null) || (str2.equals(str3)))
      {
        localTreeItem.setText(k + 2, str2);
      }
      else
      {
        localTreeItem.setForeground(k + 2, h.g);
        localTreeItem.setText(k + 2, str2 + " - " + str3);
      }
    }
    if (paramIRuleLog.hasChild())
      for (k = 0; k < paramIRuleLog.getChildRules().size(); k++)
        a(localTreeItem, (IRuleLog)paramIRuleLog.getChildRules().get(k));
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  public String a()
  {
    if (this.f == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    TreeColumn[] arrayOfTreeColumn = this.f.getColumns();
    for (int k = 1; k < arrayOfTreeColumn.length; k++)
      localStringBuffer.append(arrayOfTreeColumn[k].getText() + ",");
    localStringBuffer.append("\n");
    TreeItem[] arrayOfTreeItem = this.f.getItems();
    for (int m = 0; m < arrayOfTreeItem.length; m++)
    {
      for (int n = 1; n < arrayOfTreeColumn.length; n++)
        if (arrayOfTreeItem[m].getData(String.valueOf(n)) != null)
          localStringBuffer.append((String)arrayOfTreeItem[m].getData(String.valueOf(n)) + ",");
        else
          localStringBuffer.append(arrayOfTreeItem[m].getText(n) + ",");
      localStringBuffer.append("\n");
    }
    return localStringBuffer.toString();
  }

  protected void okPressed()
  {
    super.okPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.u
 * JD-Core Version:    0.6.0
 */