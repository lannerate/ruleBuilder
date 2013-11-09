package com.flagleader.builder.a.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.List;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aL extends MouseAdapter
{
  aL(aI paramaI)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    aO localaO;
    Object localObject;
    if (aI.d(this.a) != null)
    {
      localaO = new aO(this.a, aI.d(this.a).getText(0), aI.d(this.a).getText(1), aI.d(this.a).getText(2));
      if ((localaO.open() == 0) && (localaO.a().length() > 0) && ((!localaO.a().equals(aI.d(this.a).getText(0))) || (!localaO.b().equals(aI.d(this.a).getText(1)))))
      {
        aI.d(this.a).setText(0, localaO.a());
        aI.d(this.a).setText(1, localaO.b());
        aI.d(this.a).setText(2, localaO.c());
        if (this.a.e().getPropertiesList().get(aI.a(this.a).getSelectionIndex()) != null)
        {
          localObject = (AdvancedProperty)this.a.e().getPropertiesList().get(aI.a(this.a).getSelectionIndex());
          ((AdvancedProperty)localObject).setKey(localaO.a());
          ((AdvancedProperty)localObject).setProperty(localaO.b());
          this.a.e().setModified(true);
        }
      }
    }
    else
    {
      localaO = new aO(this.a);
      if ((localaO.open() == 0) && (localaO.a().length() > 0))
      {
        localObject = new TableItem(aI.a(this.a), 0);
        ((TableItem)localObject).setText(new String[] { localaO.a(), localaO.b(), localaO.c() });
        this.a.e().getPropertiesList().add(new AdvancedProperty(localaO.a(), localaO.b()));
        this.a.e().setModified(true);
      }
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    aI.e(this.a);
    this.a.notifyObservers();
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint;
    TableItem localTableItem;
    if (paramMouseEvent.button == 1)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableItem = aI.a(this.a).getItem(localPoint);
      if (localTableItem == null)
        aI.a(this.a).setSelection(new TableItem[0]);
    }
    if (paramMouseEvent.button == 3)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableItem = aI.a(this.a).getItem(localPoint);
      Menu localMenu = h.a();
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("add.DataDialog", "add"));
      localMenuItem.addListener(13, new aM(this));
      if (aI.a(this.a).getSelectionCount() > 0)
      {
        localMenuItem = new MenuItem(localMenu, 2);
        aI.a(this.a, localMenu, "cut");
        aI.a(this.a, localMenu, "copy");
        aI.a(this.a, localMenu, "paste");
        localMenuItem = new MenuItem(localMenu, 2);
        aI.a(this.a, localMenu, "delete");
      }
      if ((aI.d(this.a) != null) && (aI.a(this.a).getSelectionCount() == 1))
      {
        localMenuItem = new MenuItem(localMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("edit.DataDialog", "edit"));
        localMenuItem.addListener(13, new aN(this));
        aI.a(this.a, localMenu, "moveUp");
        aI.a(this.a, localMenu, "moveDown");
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aL
 * JD-Core Version:    0.6.0
 */