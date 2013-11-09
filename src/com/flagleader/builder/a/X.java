package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.M;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

class X extends MouseAdapter
{
  X(b paramb, Label paramLabel, ISelectorEditen paramISelectorEditen)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Shell localShell = new Shell(16);
      int i = this.b.getLocation().x;
      int j = this.b.getLocation().y;
      localShell.setLocation(this.b.getLocation());
      M localM = new M(localShell, StringUtil.replace("\\n", FileUtil.newline, this.c.getText()), paramMouseEvent.x, paramMouseEvent.y, 300, 100);
      if ((localM.open() == 0) && (!this.a.g()))
      {
        String str = localM.a();
        str = StringUtil.replace(FileUtil.newline, "\\n", str);
        if (str.trim().length() > 0)
          str = str.trim();
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
      b.a(this.a, paramMouseEvent);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.X
 * JD-Core Version:    0.6.0
 */