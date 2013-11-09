package org.agilemore.agilegrid;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class p
  implements Listener
{
  private Shell c = null;
  private Label d = null;
  private Display e;
  final Listener a = new q(this);

  public p(e parame)
  {
    this.e = parame.getDisplay();
  }

  public void handleEvent(Event paramEvent)
  {
    switch (paramEvent.type)
    {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 12:
    case 13:
      if (this.c == null)
        break;
      this.c.dispose();
      this.c = null;
      this.d = null;
      break;
    case 32:
      if ((this.c != null) && (!this.c.isDisposed()))
        this.c.dispose();
      G localG = this.b.o(paramEvent.x, paramEvent.y);
      String str = e.a(this.b).g(localG.c, localG.d);
      if (((str != null) && (!str.equals(""))) || ((e.b(this.b) == null) || (e.b(this.b).equals("")) || (localG == null) || (localG.d == -2147483648) || (localG.c == -2147483648)))
      {
        this.c = null;
        this.d = null;
        return;
      }
      this.c = new Shell(this.b.getShell(), 16384);
      GridLayout localGridLayout = new GridLayout();
      localGridLayout.marginWidth = 2;
      localGridLayout.marginHeight = 2;
      this.c.setLayout(localGridLayout);
      this.c.setBackground(this.e.getSystemColor(29));
      this.d = new Label(this.c, 0);
      this.d.setLayoutData(new GridData(1808));
      this.d.setForeground(this.e.getSystemColor(28));
      this.d.setBackground(this.e.getSystemColor(29));
      if ((str != null) && (!str.equals("")))
        this.d.setText(str);
      else
        this.d.setText(e.b(this.b));
      this.d.addListener(7, this.a);
      this.d.addListener(3, this.a);
      this.d.addListener(5, this.a);
      Point localPoint1 = this.c.computeSize(-1, -1);
      int i = 20;
      int j = 0;
      if ((e.c(this.b) != null) && (e.c(this.b).x >= 0) && (e.c(this.b).y >= 0))
      {
        i = e.c(this.b).y + 1;
        j = -e.c(this.b).x;
      }
      Rectangle localRectangle = this.b.getBounds();
      if (paramEvent.x + j + localPoint1.x > localRectangle.x + localRectangle.width)
        paramEvent.x -= paramEvent.x + j + localPoint1.x - localRectangle.x - localRectangle.width;
      if (paramEvent.y + i + localPoint1.y > localRectangle.y + localRectangle.height)
        paramEvent.y -= paramEvent.y + i + localPoint1.y - localRectangle.y - localRectangle.height;
      Point localPoint2 = this.b.toDisplay(paramEvent.x + j, paramEvent.y + i);
      this.c.setBounds(localPoint2.x, localPoint2.y, localPoint1.x, localPoint1.y);
      this.c.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.p
 * JD-Core Version:    0.6.0
 */