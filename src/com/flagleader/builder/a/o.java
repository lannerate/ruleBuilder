package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.util.List;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

class o extends MouseAdapter
{
  o(b paramb, Label paramLabel, ITextEditen paramITextEditen1, ITextEditen paramITextEditen2)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Object localObject1;
    if (paramMouseEvent.button == 1)
    {
      if ((SystemUtils.IS_OS_MAC_OSX) || (SystemUtils.IS_OS_MAC))
      {
        localObject1 = new Shell(16);
        int i = this.b.getLocation().x;
        int j = this.b.getLocation().y;
        ((Shell)localObject1).setLocation(this.b.getLocation());
        M localM = new M((Shell)localObject1, StringUtil.replace("\\n", FileUtil.newline, this.c.getText()), paramMouseEvent.x, paramMouseEvent.y, 300, 100);
        if ((localM.open() == 0) && (!this.a.g()))
        {
          String str = localM.a();
          str = StringUtil.replace(FileUtil.newline, "\\n", str);
          if (str.trim().length() > 0)
            str = str.trim();
          if ((str.endsWith("\\n")) && (str.length() > 2))
            str = str.substring(0, str.length() - 2);
          if (!this.c.getText().equals(str))
          {
            if (!this.c.checkValue(str))
              this.a.b.showError(ResourceTools.getMessage("errorType.edit"));
            this.c.setText(str);
            this.c.update();
          }
        }
      }
      else
      {
        localObject1 = new p(this, StringUtil.replace("\\n", FileUtil.newline, this.d.getDisplayName()), this.c);
        ((com.flagleader.builder.b.r)localObject1).a(this.b);
      }
    }
    else if (paramMouseEvent.button == 3)
    {
      localObject1 = h.a();
      Object localObject2;
      if (this.a.f().size() > 0)
      {
        if (!this.a.g())
        {
          localObject2 = new MenuItem((Menu)localObject1, 64);
          ((MenuItem)localObject2).setText(this.a.c("cut.popup"));
          ((MenuItem)localObject2).addListener(13, new q(this));
        }
        if (paramMouseEvent.button == 3)
        {
          localObject2 = new MenuItem((Menu)localObject1, 64);
          ((MenuItem)localObject2).setText(this.a.c("copy.popup"));
          ((MenuItem)localObject2).addListener(13, new r(this));
        }
        if (!this.a.g())
        {
          localObject2 = new MenuItem((Menu)localObject1, 64);
          ((MenuItem)localObject2).setText(this.a.c("delete.popup"));
          ((MenuItem)localObject2).addListener(13, new s(this));
        }
      }
      else if (paramMouseEvent.button == 3)
      {
        localObject2 = this.c.getText();
        MenuItem localMenuItem;
        if (((String)localObject2).length() > 0)
        {
          if (!this.a.g())
          {
            localMenuItem = new MenuItem((Menu)localObject1, 64);
            localMenuItem.setText(this.a.c("cut.popup"));
            localMenuItem.addListener(13, new t(this, this.c, (String)localObject2));
          }
          localMenuItem = new MenuItem((Menu)localObject1, 64);
          localMenuItem.setText(this.a.c("copy.popup"));
          localMenuItem.addListener(13, new u(this, (String)localObject2));
        }
        if (!this.a.g())
        {
          localMenuItem = new MenuItem((Menu)localObject1, 64);
          localMenuItem.setText(this.a.c("paste.popup"));
          localMenuItem.addListener(13, new v(this, this.c));
        }
      }
      ((Menu)localObject1).setEnabled(true);
      ((Menu)localObject1).setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.o
 * JD-Core Version:    0.6.0
 */