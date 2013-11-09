package com.flagleader.builder.a.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import java.util.HashMap;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class ah extends MouseAdapter
{
  ah(af paramaf)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    G localG = this.a.e.A();
    if (localG == null)
      return;
    Object localObject1 = af.e(this.a).get(new av(localG.c, localG.d));
    Menu localMenu;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramMouseEvent.button == 3) && (localObject1 != null))
    {
      localMenu = h.a();
      if (!af.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("cut.popup"));
        ((MenuItem)localObject2).addListener(13, new ai(this, localObject1));
      }
      localObject2 = new MenuItem(localMenu, 64);
      ((MenuItem)localObject2).setText(ResourceTools.getMessage("copy.popup"));
      ((MenuItem)localObject2).addListener(13, new an(this, localObject1));
      if (!af.c(this.a))
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
            ((MenuItem)localObject2).addListener(13, new ao(this, localObject1, localObject4));
          }
          else if (((localObject1 instanceof DecisionValue)) && (((DecisionValue)localObject1).getAssignValue().canPasteObject(localObject4)))
          {
            localObject2 = new MenuItem(localMenu, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
            ((MenuItem)localObject2).addListener(13, new ap(this, localObject1, localObject4));
          }
        if ((localObject1 instanceof IConditionToken))
        {
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("copyadd.popup"));
          ((MenuItem)localObject2).addListener(13, new aq(this, localObject1));
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup"));
          ((MenuItem)localObject2).addListener(13, new ar(this, localG));
          if (localG.c > 1)
          {
            localObject2 = new MenuItem(localMenu, 64);
            ((MenuItem)localObject2).setText(ResourceTools.getMessage("addnextcondition.popup"));
            ((MenuItem)localObject2).addListener(13, new as(this, localG));
          }
        }
        else if ((localObject1 instanceof DecisionValue))
        {
          localObject2 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject2).setText(ResourceTools.getMessage("edit.popup"));
          ((MenuItem)localObject2).addListener(13, new at(this, localObject1));
        }
      }
      if (!af.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("delete.popup"));
        ((MenuItem)localObject2).addListener(13, new au(this, localObject1));
      }
      localObject2 = new MenuItem(localMenu, 8);
      ((MenuItem)localObject2).setText(ResourceTools.getMessage("update.edit"));
      ((MenuItem)localObject2).addListener(13, new aj(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
    else if ((paramMouseEvent.button == 3) && (localG.c == 1) && (localG.d == 0))
    {
      localMenu = h.a();
      if (!af.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
        ((MenuItem)localObject2).addListener(13, new ak(this));
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
    else if ((paramMouseEvent.button == 3) && (localG.c == 0) && (localG.d == af.a(this.a).getConditionNum()))
    {
      localMenu = h.a();
      if (!af.c(this.a))
      {
        localObject2 = new MenuItem(localMenu, 64);
        ((MenuItem)localObject2).setText(ResourceTools.getMessage("paste.popup"));
        ((MenuItem)localObject2).addListener(13, new al(this));
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
    else if ((paramMouseEvent.button == 3) && (localG.c == 0) && (localG.d == 0))
    {
      localMenu = h.a();
      if (!af.c(this.a))
      {
        localObject2 = new Clipboard(Display.getCurrent()).getContents(d.a());
        localObject3 = localObject2;
        if ((localObject3 != null) && (af.a(this.a).canPasteValueElement(localObject3)))
        {
          localObject4 = new MenuItem(localMenu, 64);
          ((MenuItem)localObject4).setText(ResourceTools.getMessage("paste.popup"));
          ((MenuItem)localObject4).addListener(13, new am(this, localObject3));
        }
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ah
 * JD-Core Version:    0.6.0
 */