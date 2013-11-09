package com.flagleader.builder.a.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import java.util.HashMap;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class q extends MouseAdapter
{
  q(o paramo)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    org.agilemore.agilegrid.G localG = this.a.e.A();
    if (localG == null)
      return;
    Object localObject1 = o.e(this.a).get(new G(localG.c, localG.d));
    Menu localMenu;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramMouseEvent.button == 3) && (localObject1 != null))
    {
      localMenu = h.a();
      if (!o.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("cut.popup"));
        ((MenuItem)localObject2).addListener(13, new r(this, localObject1));
      }
      localObject2 = new MenuItem(localMenu, 64);
      ((MenuItem)localObject2).setText(ResourceTools.getMessage("copy.popup"));
      ((MenuItem)localObject2).addListener(13, new y(this, localObject1));
      if (!o.c(this.a))
      {
        localObject3 = new Clipboard(Display.getCurrent()).getContents(d.a());
        if ((localObject3 == null) || (!(localObject3 instanceof IElement)))
          localObject3 = new Clipboard(Display.getCurrent()).getContents(TextTransfer.getInstance());
        localObject4 = localObject3;
        if (localObject4 != null)
          if (((localObject1 instanceof IConditionToken)) && (((IConditionToken)localObject1).getComparedValue() != null) && (((IConditionToken)localObject1).getComparedValue().canPasteObject(localObject4)))
          {
            localObject2 = new MenuItem(localMenu, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new z(this, localObject1, localObject4));
          }
          else if (((localObject1 instanceof DecisionElementValue)) && (((DecisionElementValue)localObject1).getAssignValue().canPasteObject(localObject4)))
          {
            localObject2 = new MenuItem(localMenu, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new A(this, localObject1, localObject4));
          }
          else if (((localObject1 instanceof DecisionRelateAction)) && ((localObject4 instanceof IElement)) && (((DecisionRelateAction)localObject1).getThenActions().canPasteElement((IElement)localObject4)))
          {
            localObject2 = new MenuItem(localMenu, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new B(this, localObject1, localObject4));
          }
        if ((localObject1 instanceof IConditionToken))
        {
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("copyadd.popup"));
          ((MenuItem)localObject2).addListener(13, new C(this, localObject1));
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup"));
          ((MenuItem)localObject2).addListener(13, new D(this, localG));
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("addnextcondition.popup"));
          ((MenuItem)localObject2).addListener(13, new E(this, localG));
        }
        else if ((localObject1 instanceof DecisionElementValue))
        {
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup"));
          ((MenuItem)localObject2).addListener(13, new F(this, localObject1));
        }
        else if ((localObject1 instanceof DecisionRelateAction))
        {
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup"));
          ((MenuItem)localObject2).addListener(13, new s(this, localObject1));
        }
      }
      if (!o.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("delete.popup"));
        ((MenuItem)localObject2).addListener(13, new t(this, localObject1));
      }
      localObject2 = new MenuItem(localMenu, 8);
      ((MenuItem)localObject2).setText(ResourceTools.getMessage("update.edit"));
      ((MenuItem)localObject2).addListener(13, new u(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
    else if ((paramMouseEvent.button == 3) && (localG.c == 0) && (localG.d == 0))
    {
      localMenu = h.a();
      if (!o.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
        ((MenuItem)localObject2).addListener(13, new v(this));
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
    else if ((paramMouseEvent.button == 3) && (localG.c == 0) && (localG.d >= o.a(this.a).getConditionNum()) && (localG.d < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()))
    {
      localMenu = h.a();
      if (!o.c(this.a))
      {
        localObject2 = new Clipboard(Display.getCurrent()).getContents(d.a());
        localObject3 = localObject2;
        if ((localObject3 != null) && (o.a(this.a).canPasteValueElement(localG.d - o.a(this.a).getConditionNum() + 1, localObject3)))
        {
          localObject4 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject4).setText(ResourceTools.getMessage("paste.popup"));
          ((MenuItem)localObject4).addListener(13, new w(this, localG, localObject3));
        }
        if ((localG.d - o.a(this.a).getConditionNum() >= 0) && (localG.d - o.a(this.a).getConditionNum() < o.a(this.a).getValueNum()))
        {
          localObject4 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject4).setText(ResourceTools.getMessage("delete.popup"));
          ((MenuItem)localObject4).addListener(13, new x(this, localG));
        }
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.q
 * JD-Core Version:    0.6.0
 */