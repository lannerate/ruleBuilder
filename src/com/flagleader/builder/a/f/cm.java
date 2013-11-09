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

class cm extends MouseAdapter
{
  cm(ck paramck)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    G localG = this.a.e.A();
    if (localG == null)
      return;
    IMultiLineEditen localIMultiLineEditen = (IMultiLineEditen)ck.g(this.a).get(new cs(localG.c, localG.d));
    if ((paramMouseEvent.button == 3) && (localIMultiLineEditen != null))
    {
      Menu localMenu = h.a();
      if (!ck.c(this.a))
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
        localMenuItem.addListener(13, new cn(this, localIMultiLineEditen));
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 64);
      localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
      localMenuItem.addListener(13, new co(this, localIMultiLineEditen));
      if (!ck.c(this.a))
      {
        Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
        Object localObject2 = localObject1;
        if ((localObject2 != null) && ((localObject2 instanceof IElement)) && (localIMultiLineEditen.canPasteElement((IElement)localObject2)))
        {
          localMenuItem = new MenuItem(localMenu, 64);
          localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
          localMenuItem.addListener(13, new cp(this, localIMultiLineEditen, localObject2));
        }
      }
      if (!ck.c(this.a))
      {
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
        localMenuItem.addListener(13, new cq(this, localG));
      }
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.edit"));
      localMenuItem.addListener(13, new cr(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cm
 * JD-Core Version:    0.6.0
 */