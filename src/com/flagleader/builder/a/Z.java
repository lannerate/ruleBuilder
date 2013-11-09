package com.flagleader.builder.a;

import com.flagleader.builder.dialogs.e.bC;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

class Z extends MouseAdapter
{
  Z(b paramb, Label paramLabel, ISheetFieldsSelectEditen paramISheetFieldsSelectEditen1, ISheetFieldsSelectEditen paramISheetFieldsSelectEditen2)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Object localObject1;
    Object localObject2;
    if (paramMouseEvent.button == 1)
    {
      localObject1 = new Shell(16);
      ((Shell)localObject1).setLocation(this.b.getLocation());
      localObject2 = new bC((Shell)localObject1, this.c);
      if (((bC)localObject2).open() == 0)
      {
        this.c.getRoot().setModified(true);
        this.c.setSelected(((bC)localObject2).a());
        this.c.update();
      }
    }
    else
    {
      localObject1 = h.a();
      localObject2 = this.d.getMemberElement();
      if ((localObject2 != null) && ((localObject2 instanceof ITreeNode)))
      {
        ITreeNode localITreeNode = (ITreeNode)localObject2;
        MenuItem localMenuItem = new MenuItem((Menu)localObject1, 64);
        localMenuItem.setText(this.a.c("finddefine.popup"));
        localMenuItem.addListener(13, new aa(this, localITreeNode));
      }
      ((Menu)localObject1).setEnabled(true);
      ((Menu)localObject1).setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.Z
 * JD-Core Version:    0.6.0
 */