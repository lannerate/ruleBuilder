package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.a;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class aR extends MouseAdapter
{
  private TreeItem b;
  private TreeItem c;

  aR(aO paramaO)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Object localObject;
    if ((aO.c(this.a).getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) == null) && (paramMouseEvent.button == 3))
    {
      aO.a(this.a, h.a());
      if (this.a.b.h())
      {
        localObject = new MenuItem(aO.a(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("undo.popup", "undo"));
        ((MenuItem)localObject).addListener(13, new aS(this));
      }
      if (this.a.b.i())
      {
        localObject = new MenuItem(aO.a(this.a), 8);
        ((MenuItem)localObject).setText(ResourceTools.getMessage("redo.popup", "redo"));
        ((MenuItem)localObject).addListener(13, new aT(this));
      }
      localObject = new MenuItem(aO.a(this.a), 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("update.popup", "update"));
      ((MenuItem)localObject).addListener(13, new aU(this));
      aO.a(this.a).setEnabled(true);
      aO.a(this.a).setVisible(true);
      return;
    }
    if ((this.a.c() != null) && ((paramMouseEvent.stateMask & SWT.MOD1) == 0))
    {
      aO.d(this.a).getMenuAndToolBar().a(null);
      if (paramMouseEvent.button == 1)
      {
        localObject = new Point(paramMouseEvent.x, paramMouseEvent.y);
        this.b = aO.c(this.a).getItem((Point)localObject);
        if (this.b == null)
          return;
        this.c = this.b;
        aO.e(this.a).put(this.c, new Date());
        aO.d(this.a).getRuleEditor().a(this.a.c());
      }
      else if (paramMouseEvent.button == 3)
      {
        if (this.a.c() != null)
          aO.f(this.a).a(this.a.a());
        else
          aO.c(this.a).setMenu(null);
      }
    }
    else if ((aO.c(this.a).getSelectionCount() > 1) && (paramMouseEvent.button == 3))
    {
      if ((aO.a(this.a) != null) && (!aO.a(this.a).isDisposed()))
        aO.a(this.a).dispose();
      aO.a(this.a, h.a());
      localObject = new MenuItem(aO.a(this.a), 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("cut.popup", "cut"));
      ((MenuItem)localObject).addListener(13, new aV(this));
      localObject = new MenuItem(aO.a(this.a), 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("copy.popup", "copy"));
      ((MenuItem)localObject).addListener(13, new aW(this));
      localObject = new MenuItem(aO.a(this.a), 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("delete.popup", "delete"));
      ((MenuItem)localObject).addListener(13, new aX(this));
      aO.a(this.a).setEnabled(true);
      aO.a(this.a).setVisible(true);
    }
    else
    {
      aO.c(this.a).setMenu(null);
    }
    aO.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aR
 * JD-Core Version:    0.6.0
 */