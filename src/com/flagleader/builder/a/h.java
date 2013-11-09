package com.flagleader.builder.a;

import com.flagleader.builder.dialogs.e.C;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.tree.IRuleClass;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

class h extends MouseAdapter
{
  h(b paramb, Label paramLabel, ISelectRulePackageEditen paramISelectRulePackageEditen1, ISelectRulePackageEditen paramISelectRulePackageEditen2)
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
      localObject2 = new C((Shell)localObject1, this.c, this.a.b);
      if (((C)localObject2).open() == 0)
      {
        this.c.setModified(true);
        this.c.update();
      }
    }
    else
    {
      localObject1 = com.flagleader.builder.widget.h.a();
      localObject2 = this.d.getSourceSheet();
      if (localObject2 != null)
      {
        MenuItem localMenuItem = new MenuItem((Menu)localObject1, 64);
        localMenuItem.setText(this.a.c("finddefine.popup"));
        localMenuItem.addListener(13, new i(this, (IRuleClass)localObject2));
      }
      ((Menu)localObject1).setEnabled(true);
      ((Menu)localObject1).setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.h
 * JD-Core Version:    0.6.0
 */