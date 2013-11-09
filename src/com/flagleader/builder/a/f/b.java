package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.p;
import com.flagleader.repository.rlm.condition.DecisionMultiConditionToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class b extends MouseAdapter
{
  b(a parama)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if (a.d(this.a))
        return;
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem1 = a.a(this.a).getItem(localPoint);
      TableItem localTableItem2 = localTableItem1;
      if (localTableItem2 == null)
        return;
      int i = a.a(this.a).getSelectionIndex();
      int j = -1;
      for (int k = 0; k < a.b(this.a).getConditionNum() + a.b(this.a).getValueNum(); k++)
      {
        if (!localTableItem2.getBounds(k + 1).contains(localPoint))
          continue;
        j = k + 1;
      }
      k = j;
      Object localObject1;
      Object localObject2;
      if ((j > 0) && (j <= a.b(this.a).getConditionNum()))
      {
        if (i == 0)
        {
          localObject1 = h.a();
          if (!a.d(this.a))
          {
            localObject2 = new MenuItem((Menu)localObject1, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new c(this, k));
          }
          ((Menu)localObject1).setEnabled(true);
          ((Menu)localObject1).setVisible(true);
        }
        else
        {
          localObject1 = new com.flagleader.builder.b.c(a.c(this.a).getShell(), a.c(this.a), (DecisionMultiConditionToken)a.b(this.a).getConditions(j));
          if (((com.flagleader.builder.b.c)localObject1).open() == 0)
            this.a.update();
        }
        return;
      }
      if ((j > 0) && (j <= a.b(this.a).getConditionNum() + a.b(this.a).getValueNum()))
      {
        if (i == 0)
        {
          localObject1 = h.a();
          if (!a.d(this.a))
          {
            localObject2 = new MenuItem((Menu)localObject1, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new d(this, k));
          }
          ((Menu)localObject1).setEnabled(true);
          ((Menu)localObject1).setVisible(true);
        }
        return;
      }
      if ((k > 0) && (localTableItem2.getData("conditions") != null) && (a.b(this.a).getDecisionElement(k - a.b(this.a).getConditionNum()) != null))
      {
        localObject1 = a.b(this.a).getDecisionValue((List)localTableItem2.getData("conditions"), a.b(this.a).getDecisionElement(k - a.b(this.a).getConditionNum()).getMemberElement());
        if (localObject1 != null)
        {
          localObject2 = new com.flagleader.builder.b.d(a.c(this.a).getShell(), a.c(this.a), (IRuleContainer)localObject1);
          if (((com.flagleader.builder.b.d)localObject2).open() == 0)
            localTableItem2.setText(k, ((DecisionElementValue)localObject1).getValue());
        }
      }
    }
    super.mouseDown(paramMouseEvent);
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (a.d(this.a))
      return;
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem1 = a.a(this.a).getItem(localPoint);
    TableItem localTableItem2 = localTableItem1;
    if ((localTableItem2 == null) || (localTableItem2.isDisposed()))
      return;
    Object localObject1 = -1;
    for (int i = 0; i < a.b(this.a).getConditionNum() + a.b(this.a).getValueNum(); i++)
    {
      if (!localTableItem2.getBounds(i + 1).contains(localPoint))
        continue;
      localObject1 = i + 1;
    }
    if ((localObject1 > 0) && (localObject1 <= a.b(this.a).getConditionNum()))
    {
      if ((localTableItem2.getData(localObject1) != null) && ((localTableItem2.getData(localObject1) instanceof ConstantToken)))
      {
        localObject2 = (ConstantToken)localTableItem2.getData(localObject1);
        a.a(this.a, new p(a.c(this.a)).a(a.a(this.a), 4));
        a.e(this.a).setFont(a.a(this.a).getFont());
        a.e(this.a).setText(((ConstantToken)localObject2).getValue());
        a.e(this.a).selectAll();
        a.f(this.a).setEditor(a.e(this.a), localTableItem2, localObject1);
        int j = localObject1;
        a.e(this.a).addFocusListener(new e(this, localTableItem2, (ConstantToken)localObject2, j));
        a.e(this.a).addTraverseListener(new f(this, localTableItem2, (ConstantToken)localObject2, j));
        a.e(this.a).setFocus();
      }
      else
      {
        localObject2 = new com.flagleader.builder.b.c(a.c(this.a).getShell(), a.c(this.a), (DecisionMultiConditionToken)a.b(this.a).getConditions(localObject1));
        if (((com.flagleader.builder.b.c)localObject2).open() == 0)
          this.a.update();
      }
      return;
    }
    Object localObject2 = localObject1;
    if ((localObject2 > 0) && (a.b(this.a).getDecisionElement(localObject2 - a.b(this.a).getConditionNum()) != null))
    {
      Object localObject3;
      if (localTableItem2.getData("conditions") != null)
      {
        localObject3 = a.b(this.a).getDecisionValue((List)localTableItem2.getData("conditions"), a.b(this.a).getDecisionElement(localObject2 - a.b(this.a).getConditionNum()).getMemberElement());
        if (localObject3 != null)
          if (!((DecisionElementValue)localObject3).isTextValue())
          {
            com.flagleader.builder.b.d locald = new com.flagleader.builder.b.d(a.c(this.a).getShell(), a.c(this.a), (IRuleContainer)localObject3);
            if (locald.open() == 0)
            {
              localTableItem2.setText(localObject2, ((DecisionElementValue)localObject3).getValue());
              a.b(this.a).setModified(true);
            }
          }
          else
          {
            a.a(this.a, localTableItem2, a.f(this.a), localObject2);
          }
      }
      else
      {
        localObject3 = new com.flagleader.builder.b.d(a.c(this.a).getShell(), a.c(this.a), a.b(this.a).getDecisionElement(localObject2 - a.b(this.a).getConditionNum()).getContainer());
        if (((com.flagleader.builder.b.d)localObject3).open() == 0)
          this.a.update();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.b
 * JD-Core Version:    0.6.0
 */