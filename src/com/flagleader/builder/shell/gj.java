package com.flagleader.builder.shell;

import com.flagleader.builder.widget.p;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class gj extends MouseAdapter
{
  gj(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (TestRuleServerDialog.d(this.a) != null)
    {
      localObject1 = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TestRuleServerDialog.a(this.a, TestRuleServerDialog.c(this.a).getItem((Point)localObject1));
      if (TestRuleServerDialog.e(this.a) == null)
        return;
      localObject2 = TestRuleServerDialog.e(this.a).getBounds(1);
      if (((Rectangle)localObject2).contains((Point)localObject1))
      {
        localObject3 = new p().a(TestRuleServerDialog.c(this.a), 4);
        ((Text)localObject3).setText(TestRuleServerDialog.e(this.a).getText(1));
        TestRuleServerDialog.a(this.a, TestRuleServerDialog.e(this.a), (Text)localObject3, TestRuleServerDialog.f(this.a), 1);
        ((Text)localObject3).setFocus();
      }
      else
      {
        localObject3 = new go(this.a, TestRuleServerDialog.d(this.a).getText(0), TestRuleServerDialog.d(this.a).getText(1), TestRuleServerDialog.d(this.a).getText(2));
        if ((((go)localObject3).open() == 0) && (((go)localObject3).a().length() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer(((go)localObject3).b());
          if ((!((go)localObject3).a().equals(TestRuleServerDialog.d(this.a).getText(0))) || (!localStringBuffer.toString().equals(TestRuleServerDialog.d(this.a).getText(1))))
          {
            TestRuleServerDialog.d(this.a).setText(0, ((go)localObject3).a());
            TestRuleServerDialog.d(this.a).setText(1, localStringBuffer.toString());
            TestRuleServerDialog.a(this.a, true);
          }
        }
      }
    }
    else
    {
      localObject1 = new go(this.a);
      if ((((go)localObject1).open() == 0) && (((go)localObject1).a().length() > 0))
      {
        localObject2 = new StringBuffer(((go)localObject1).b());
        localObject3 = new TableItem(TestRuleServerDialog.c(this.a), 0);
        ((TableItem)localObject3).setText(new String[] { ((go)localObject1).a(), ((StringBuffer)localObject2).toString() });
        TestRuleServerDialog.a(this.a, true);
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = TestRuleServerDialog.c(this.a).getItem(localPoint);
      if (localTableItem == null)
        TestRuleServerDialog.c(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.gj
 * JD-Core Version:    0.6.0
 */