package com.flagleader.builder.shell;

import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class o extends MouseAdapter
{
  o(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = ClassInfoEditor.d(this.a).getLineAtOffset(ClassInfoEditor.d(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < ClassInfoEditor.h(this.a).length) && (ClassInfoEditor.h(this.a)[i] >= 0))
        ClassInfoEditor.i(this.a).setSelection(ClassInfoEditor.h(this.a)[i], ClassInfoEditor.i(this.a).getText().indexOf(FileUtil.newline, ClassInfoEditor.h(this.a)[i]));
    }
    catch (RuntimeException localRuntimeException)
    {
      ClassInfoEditor.d(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.o
 * JD-Core Version:    0.6.0
 */