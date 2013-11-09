package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.b.d;
import com.flagleader.builder.b.e;
import com.flagleader.builder.b.f;
import com.flagleader.builder.widget.p;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class Y extends MouseAdapter
{
  Y(X paramX)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((X.d(this.a)) || (X.b(this.a).isEmpty()))
        return;
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem1 = X.a(this.a).getItem(localPoint);
      TableItem localTableItem2 = localTableItem1;
      if (localTableItem2 == null)
        return;
      int i = -1;
      for (int j = 0; j < X.b(this.a).getConditionNum() + X.b(this.a).getValueNum(); j++)
      {
        if (!localTableItem2.getBounds(j + 1).contains(localPoint))
          continue;
        i = j + 1;
      }
      j = i;
      Object localObject;
      if ((i > 0) && (i <= X.b(this.a).getConditionNum()))
      {
        if (j == 1)
        {
          localObject = new f(X.c(this.a).getShell(), X.c(this.a), X.b(this.a));
          if (((f)localObject).open() == 0)
            this.a.update();
        }
        else if ((localTableItem2.getData("conditions") != null) && (((List)localTableItem2.getData("conditions")).get(j - 2) != null))
        {
          localObject = new e(X.c(this.a).getShell(), X.c(this.a), X.b(this.a).getRelateCondition((IConditionToken)((List)localTableItem2.getData("conditions")).get(j - 2), j - 1));
          if (((e)localObject).open() == 0)
            this.a.update();
        }
        return;
      }
      if ((j > 0) && (localTableItem2.getData("conditions") != null) && (j - X.b(this.a).getConditionNum() > 0) && (j - X.b(this.a).getConditionNum() <= X.b(this.a).getValueNum()))
      {
        localObject = X.b(this.a).getDecisionValue((List)localTableItem2.getData("conditions"), X.b(this.a).getDecisionElement(j - X.b(this.a).getConditionNum()).getMemberElement());
        if (localObject != null)
        {
          d locald = new d(X.c(this.a).getShell(), X.c(this.a), (IRuleContainer)localObject);
          if (locald.open() == 0)
            localTableItem2.setText(j, ((DecisionElementValue)localObject).getValue());
        }
      }
    }
    super.mouseDown(paramMouseEvent);
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if ((X.d(this.a)) || (X.b(this.a).isEmpty()))
      return;
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem1 = X.a(this.a).getItem(localPoint);
    TableItem localTableItem2 = localTableItem1;
    if ((localTableItem2 == null) || (localTableItem2.isDisposed()))
      return;
    int i = -1;
    for (int j = 0; j < X.b(this.a).getConditionNum() + X.b(this.a).getValueNum(); j++)
    {
      if (!localTableItem2.getBounds(j + 1).contains(localPoint))
        continue;
      i = j + 1;
    }
    Object localObject1;
    for (j = 1; j <= X.b(this.a).getConditionNum(); j++)
    {
      if ((localTableItem2.isDisposed()) || (!localTableItem2.getBounds(j).contains(localPoint)))
        continue;
      if ((localTableItem2.getData(i) != null) && ((localTableItem2.getData(i) instanceof ConstantToken)))
      {
        localObject1 = (ConstantToken)localTableItem2.getData(i);
        X.a(this.a, new p(X.c(this.a)).a(X.a(this.a), 4));
        X.e(this.a).setFont(X.a(this.a).getFont());
        X.e(this.a).setText(((ConstantToken)localObject1).getValue());
        X.e(this.a).selectAll();
        X.f(this.a).setEditor(X.e(this.a), localTableItem2, i);
        int k = i;
        X.e(this.a).addFocusListener(new Z(this, localTableItem2, (ConstantToken)localObject1, k));
        X.e(this.a).addTraverseListener(new aa(this, localTableItem2, (ConstantToken)localObject1, k));
        X.e(this.a).setFocus();
      }
      else if (j == 1)
      {
        localObject1 = new f(X.c(this.a).getShell(), X.c(this.a), X.b(this.a));
        if (((f)localObject1).open() == 0)
          this.a.update();
      }
      else if ((localTableItem2.getData("conditions") != null) && (((List)localTableItem2.getData("conditions")).get(j - 2) != null))
      {
        localObject1 = new e(X.c(this.a).getShell(), X.c(this.a), X.b(this.a).getRelateCondition((IConditionToken)((List)localTableItem2.getData("conditions")).get(j - 2), j - 1));
        if (((e)localObject1).open() == 0)
          this.a.update();
      }
      return;
    }
    if ((localTableItem2 == null) || (localTableItem2.isDisposed()))
      return;
    j = i;
    if ((j > 0) && (localTableItem2.getData("conditions") != null) && (j - X.b(this.a).getConditionNum() > 0) && (j - X.b(this.a).getConditionNum() <= X.b(this.a).getValueNum()))
    {
      localObject1 = X.b(this.a).getDecisionValue((List)localTableItem2.getData("conditions"), X.b(this.a).getDecisionElement(j - X.b(this.a).getConditionNum()).getMemberElement());
      if (localObject1 != null)
      {
        Object localObject2;
        if (!((DecisionElementValue)localObject1).isTextValue())
        {
          localObject2 = new d(X.c(this.a).getShell(), X.c(this.a), (IRuleContainer)localObject1);
          if (((d)localObject2).open() == 0)
          {
            localTableItem2.setText(j, ((DecisionElementValue)localObject1).getValue());
            X.b(this.a).setModified(true);
          }
        }
        else
        {
          X.a(this.a, new p(X.c(this.a)).a(X.a(this.a), 4));
          X.e(this.a).setFont(X.a(this.a).getFont());
          if (localTableItem2.getText(j).equals(ResourceTools.getMessage("inputValue.edit")))
            X.e(this.a).setText("");
          else
            X.e(this.a).setText(localTableItem2.getText(j));
          localObject2 = X.e(this.a).getText();
          X.e(this.a).selectAll();
          X.f(this.a).setEditor(X.e(this.a), localTableItem2, j);
          X.e(this.a).addFocusListener(new ab(this, localTableItem2, (String)localObject2, j));
          X.e(this.a).addTraverseListener(new ac(this, localTableItem2, j));
          X.e(this.a).setFocus();
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.Y
 * JD-Core Version:    0.6.0
 */