package com.flagleader.builder.a.f;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import java.util.HashMap;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class bS extends MouseAdapter
{
  bS(bQ parambQ)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    G localG = this.a.e.A();
    if (localG == null)
      return;
    Object localObject1 = bQ.h(this.a).get(new bY(localG.c, localG.d));
    if ((paramMouseEvent.button == 3) && (localObject1 != null) && ((localObject1 instanceof IMultiLineEditen)))
    {
      IMultiLineEditen localIMultiLineEditen = (IMultiLineEditen)localObject1;
      Menu localMenu = h.a();
      if (!bQ.a(this.a))
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
        localMenuItem.addListener(13, new bT(this, localIMultiLineEditen));
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 64);
      localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
      localMenuItem.addListener(13, new bU(this, localIMultiLineEditen));
      if (!bQ.a(this.a))
      {
        Object localObject2 = new Clipboard(Display.getCurrent()).getContents(d.a());
        Object localObject3 = localObject2;
        if ((localObject3 != null) && ((localObject3 instanceof IElement)) && (localIMultiLineEditen.canPasteElement((IElement)localObject3)))
        {
          localMenuItem = new MenuItem(localMenu, 64);
          localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
          localMenuItem.addListener(13, new bV(this, localIMultiLineEditen, localObject3));
        }
      }
      if (!bQ.a(this.a))
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
        localMenuItem.addListener(13, new bW(this, localG, localIMultiLineEditen));
      }
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.edit"));
      localMenuItem.addListener(13, new bX(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bS
 * JD-Core Version:    0.6.0
 */