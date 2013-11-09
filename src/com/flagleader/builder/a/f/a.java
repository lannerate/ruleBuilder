package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.p;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

public class a extends aS
  implements IElementViewer
{
  private Table f;
  private TableEditor g;
  private Text q;
  int e = 0;

  public a(DecisionMultiRule paramDecisionMultiRule, Composite paramComposite, bu parambu)
  {
    super(paramDecisionMultiRule, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new a((DecisionMultiRule)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  protected void h()
  {
    a(new i(this));
    a(new l(this));
    a(new m(this));
    a(new j(this));
    a(new k(this));
    a(new n(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    a(paramToolBar, "AddValue");
    super.a(paramToolBar);
    a(paramToolBar, "AllowSheet");
    a(paramToolBar, "RuleOrder");
  }

  private DecisionMultiRule f()
  {
    return (DecisionMultiRule)this.c;
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
      this.f.addMouseListener(new b(this));
  }

  private void a(TableItem paramTableItem, TableEditor paramTableEditor, int paramInt)
  {
    this.q = new p(a()).a(this.f, 4);
    this.q.setFont(this.f.getFont());
    if (paramTableItem.getText(paramInt).equals(ResourceTools.getMessage("inputValue.edit")))
      this.q.setText("");
    else
      this.q.setText(paramTableItem.getText(paramInt));
    String str = this.q.getText();
    this.q.selectAll();
    paramTableEditor.setEditor(this.q, paramTableItem, paramInt);
    this.q.addFocusListener(new g(this, paramTableItem, str, paramInt));
    this.q.addTraverseListener(new h(this, paramTableItem, str, paramInt));
    this.q.setFocus();
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
    z();
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(30);
    int j;
    if (f().getConditionNum() > 0)
      for (j = 0; j < f().getConditionNum(); j++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(u.a("decitioncondition.text", "condition") + (j + 1));
        localTableColumn.setWidth(150);
      }
    if (f().getValueNum() > 0)
      for (j = 0; j < f().getValueNum(); j++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(u.a("decisionassign.text", "assign") + (j + 1));
        localTableColumn.setWidth(100);
      }
    TableItem localTableItem = new TableItem(this.f, 0);
    localTableItem.setText(0, "");
    for (int k = 0; k < f().getConditionNum(); k++)
    {
      IMultiConditionToken localIMultiConditionToken = f().getConditions(k + 1);
      if (localIMultiConditionToken.getSameFirstValue() != null)
        localTableItem.setText(k + 1, localIMultiConditionToken.getSameFirstValue().getDisplayName());
      else
        localTableItem.setText(k + 1, "");
      localTableItem.setForeground(k + 1, com.flagleader.builder.widget.h.a);
    }
    while (k < f().getConditionNum() + f().getValueNum())
    {
      if (f().getDecisionElement(k - f().getConditionNum() + 1) != null)
        localTableItem.setText(k + 1, f().getDecisionElement(k - f().getConditionNum() + 1).getShowDisplayName());
      else
        localTableItem.setText(k + 1, "");
      localTableItem.setForeground(k + 1, com.flagleader.builder.widget.h.j);
      k++;
    }
    int m = 1;
    int[] arrayOfInt = new int[f().getConditionNum()];
    for (int n = 0; n < f().getConditionNum(); n++)
      arrayOfInt[n] = 0;
    do
    {
      localTableItem = new TableItem(this.f, 0);
      localTableItem.setText(0, m++);
      k = 0;
      ArrayList localArrayList = new ArrayList(f().getConditionNum());
      Object localObject;
      while (k < f().getConditionNum())
      {
        localObject = f().getConditions(k + 1);
        IConditionToken localIConditionToken = ((IMultiConditionToken)localObject).getCondition(arrayOfInt[k]);
        if (localIConditionToken != null)
          localArrayList.add(localIConditionToken);
        if (a(k, arrayOfInt))
        {
          if (localIConditionToken != null)
          {
            if (((IMultiConditionToken)localObject).getSameFirstValue() == null)
              localTableItem.setText(k + 1, localIConditionToken.toString());
            else if ((localIConditionToken.getCompareOperator().getType() == 0) && (!localIConditionToken.getNextTests().hasNext()))
            {
              if (localIConditionToken.getComparedValue() != null)
                localTableItem.setText(k + 1, localIConditionToken.getComparedValue().toString());
              else
                localTableItem.setText(k + 1, "");
            }
            else
              localTableItem.setText(k + 1, f().parseShortName(localIConditionToken.toString(), ((IMultiConditionToken)localObject).getSameFirstValue().toString()));
            if ((localIConditionToken.getComparedValue() != null) && ((localIConditionToken.getComparedValue().getValueElement() instanceof ConstantToken)))
              localTableItem.setData(k + 1, localIConditionToken.getComparedValue().getValueElement());
          }
          else
          {
            localTableItem.setText(k + 1, "");
          }
        }
        else
          localTableItem.setText(k + 1, "");
        localTableItem.setForeground(k + 1, Display.getDefault().getSystemColor(9));
        k++;
      }
      localTableItem.setData("conditions", localArrayList);
      while (k < f().getConditionNum() + f().getValueNum())
      {
        if (f().getDecisionElement(k - f().getConditionNum() + 1) == null)
        {
          localTableItem.setText(k + 1, "");
        }
        else
        {
          localObject = f().getDecisionValue(localArrayList, f().getDecisionElement(k - f().getConditionNum() + 1).getMemberElement());
          if ((f().getDecisionElement(k - f().getConditionNum() + 1) != null) && (localObject != null))
            localTableItem.setText(k + 1, ((DecisionElementValue)localObject).getValue());
          else
            localTableItem.setText(k + 1, "");
          if ((localObject == null) || (((DecisionElementValue)localObject).isTextValue()))
            localTableItem.setForeground(k + 1, Display.getDefault().getSystemColor(3));
          else
            localTableItem.setForeground(k + 1, Display.getDefault().getSystemColor(10));
        }
        k++;
      }
      arrayOfInt = f().getNextDecision(arrayOfInt);
    }
    while (arrayOfInt != null);
    for (int i1 = 1; i1 < this.f.getColumnCount(); i1++)
      this.f.getColumns()[i1].pack();
    super.update();
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(f());
  }

  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == paramArrayOfInt.length - 1)
      return true;
    for (int i = paramInt + 1; i < paramArrayOfInt.length; i++)
      if (paramArrayOfInt[i] > 0)
        return false;
    return true;
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < f().getMaxModifyTime()) || (this.d < f().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return f().getEditUuid() + "value";
  }

  public boolean canRedo()
  {
    return f().canRedo();
  }

  public boolean canUndo()
  {
    return f().canUndo();
  }

  public boolean redo()
  {
    return f().redo();
  }

  public boolean undo()
  {
    return f().undo();
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
 * Qualified Name:     com.flagleader.builder.a.f.a
 * JD-Core Version:    0.6.0
 */