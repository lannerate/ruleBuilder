package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.a;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;

public class X extends aS
  implements IElementViewer
{
  private int e = 1;
  private Table f;
  private TableEditor g;
  private Text q;

  public X(DecisionRelateRule paramDecisionRelateRule, Composite paramComposite, bu parambu)
  {
    super(paramDecisionRelateRule, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new X((DecisionRelateRule)this.c, paramComposite, this.a);
  }

  private DecisionRelateRule f()
  {
    return (DecisionRelateRule)this.c;
  }

  protected void h()
  {
    a(new ad(this));
    a(new ae(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    super.a(paramToolBar);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  public void b(Composite paramComposite)
  {
    this.f = new Table(paramComposite, 66304);
    this.f.setLayoutData(new GridData(1808));
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    this.g = new TableEditor(this.f);
    this.g.horizontalAlignment = 16384;
    this.g.grabHorizontal = true;
    if (!f().isLocked())
      this.f.addMouseListener(new Y(this));
  }

  private void g()
  {
    this.g.setEditor(null, null, -1);
    if ((this.q != null) && (!this.q.isDisposed()))
    {
      this.q.dispose();
      this.q = null;
    }
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(f());
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(30);
    this.e = 1;
    int j;
    if (f().getConditionNum() > 0)
      for (j = 0; j < f().getConditionNum(); j++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        if (j == 0)
          localTableColumn.setText(u.a("tv_if", "if"));
        localTableColumn.setWidth(150);
      }
    if (f().getValueNum() > 0)
      for (j = 0; j < f().getValueNum(); j++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        if (j == 0)
          localTableColumn.setText(u.a("tv_then", "then"));
        localTableColumn.setWidth(100);
      }
    TableItem localTableItem = new TableItem(this.f, 0);
    localTableItem.setText(0, "");
    for (int k = 0; k < f().getConditionNum(); k++)
    {
      localTableItem.setText(k + 1, f().getFirstMember(k + 1));
      localTableItem.setForeground(k + 1, h.a);
    }
    while (k < f().getConditionNum() + f().getValueNum())
    {
      if ((f().getDecisionElement(k - f().getConditionNum() + 1) != null) && (f().getDecisionElement(k - f().getConditionNum() + 1).getMemberElement() != null))
        localTableItem.setText(k + 1, f().getDecisionElement(k - f().getConditionNum() + 1).getMemberElement().getDisplayName());
      else
        localTableItem.setText(k + 1, "");
      localTableItem.setForeground(k + 1, h.j);
      k++;
    }
    List localList = f().getConditions().getConditionList();
    for (int m = 0; m < localList.size(); m++)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localList.get(m));
      a(localArrayList);
    }
    for (m = 1; m < this.f.getColumnCount(); m++)
      this.f.getColumns()[m].pack();
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(f());
    super.update();
  }

  private void a(List paramList)
  {
    if (paramList.size() < f().getConditionNum())
    {
      List localList = f().getNextConditions((IConditionToken)paramList.get(paramList.size() - 1), paramList.size());
      if (localList.size() == 0)
        b(paramList);
      else
        for (int i = 0; i < localList.size(); i++)
        {
          ArrayList localArrayList = new ArrayList(paramList.size() + 1);
          localArrayList.addAll(paramList);
          localArrayList.add(localList.get(i));
          a(localArrayList);
        }
    }
    else
    {
      b(paramList);
    }
  }

  private void b(List paramList)
  {
    TableItem localTableItem = new TableItem(this.f, 0);
    localTableItem.setText(0, this.e++);
    Object localObject;
    for (int i = 0; i < f().getConditionNum(); i++)
    {
      if (i < paramList.size())
      {
        localObject = StringUtil.replace(f().getFirstMember(i + 1) + u.a("EqualsTo.edit", "equals to "), "", paramList.get(i).toString());
        localTableItem.setText(i + 1, StringUtil.replace(f().getFirstMember(i + 1), "", (String)localObject));
      }
      else
      {
        localTableItem.setText(i + 1, "");
      }
      if ((paramList.size() > i) && (((IConditionToken)paramList.get(i)).getComparedValue() != null) && ((((IConditionToken)paramList.get(i)).getComparedValue().getValueElement() instanceof ConstantToken)))
        localTableItem.setData(i + 1, ((IConditionToken)paramList.get(i)).getComparedValue().getValueElement());
      localTableItem.setForeground(i + 1, Display.getDefault().getSystemColor(9));
    }
    localTableItem.setData("conditions", paramList);
    while (i < f().getConditionNum() + f().getValueNum())
    {
      if ((i - f().getConditionNum() >= 0) && (i - f().getConditionNum() < f().getValueNum()))
      {
        localTableItem.setText(i + 1, "");
      }
      else
      {
        localObject = f().getDecisionValue(paramList, f().getDecisionElement(i - f().getConditionNum() + 1).getMemberElement());
        if ((f().getDecisionElement(i - f().getConditionNum() + 1) != null) && (localObject != null))
          localTableItem.setText(i + 1, ((DecisionElementValue)localObject).getValue());
        else
          localTableItem.setText(i + 1, "");
        if ((localObject == null) || (((DecisionElementValue)localObject).isTextValue()))
          localTableItem.setForeground(i + 1, Display.getDefault().getSystemColor(3));
        else
          localTableItem.setForeground(i + 1, Display.getDefault().getSystemColor(10));
      }
      i++;
    }
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < f().getMaxModifyTime()) || (this.d < f().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return f().getEditUuid() + "value";
  }

  void e()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(f().getDisplayName());
    if (localFileDialog.open() != null)
      try
      {
        f().exportXsl(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
        MessageDialog.openInformation(new Shell(), "", c.a("HasBeenExport", new String[] { localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName() }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.X
 * JD-Core Version:    0.6.0
 */