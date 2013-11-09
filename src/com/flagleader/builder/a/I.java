package com.flagleader.builder.a;

import com.flagleader.builder.dialogs.a.s;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class I extends MouseAdapter
{
  I(b paramb, ISelectorEditen paramISelectorEditen)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if ((paramMouseEvent.button == 1) && (!this.b.isLocked()))
      {
        if ((paramMouseEvent.stateMask & SWT.MOD1) == 0)
        {
          if (this.b.hasLeftPopupMenus())
          {
            localObject1 = h.a();
            localObject2 = this.b.getLeftPopupMenus();
            try
            {
              b.a(this.a, (Menu)localObject1, localObject2);
            }
            catch (SWTError localSWTError)
            {
              this.a.a.g();
            }
          }
        }
        else if ((this.b.getBusinessObject() instanceof IBusinessObject))
        {
          localObject1 = new s(this.a.b, (IBusinessObject)this.b.getBusinessObject(), this.b.getLeftPopupMenus());
          if ((((s)localObject1).open() == 0) && (((s)localObject1).a() != null) && (((s)localObject1).a().a() != null))
            ((s)localObject1).a().a().a();
        }
      }
      else
      {
        Object localObject3;
        Object localObject4;
        if (this.b.getBusinessObject() != null)
        {
          localObject1 = h.a();
          if (this.a.f().size() > 0)
          {
            if (!this.b.isLocked())
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("cut.popup"));
              ((MenuItem)localObject2).addListener(13, new J(this));
            }
            if (paramMouseEvent.button == 3)
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("copy.popup"));
              ((MenuItem)localObject2).addListener(13, new L(this));
            }
            if (!this.b.isLocked())
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("delete.popup"));
              ((MenuItem)localObject2).addListener(13, new M(this));
            }
          }
          else if (paramMouseEvent.button == 3)
          {
            localObject2 = new MenuItem((Menu)localObject1, 64);
            ((MenuItem)localObject2).setAccelerator(SWT.MOD1 + 67);
            ((MenuItem)localObject2).setText(this.a.c("copy.popup"));
            ((MenuItem)localObject2).addListener(13, new N(this, this.b));
            if (!this.b.isLocked())
            {
              localObject3 = new Clipboard(Display.getCurrent()).getContents(d.a());
              if ((localObject3 == null) || (!(localObject3 instanceof IElement)))
                localObject3 = new Clipboard(Display.getCurrent()).getContents(TextTransfer.getInstance());
              localObject4 = localObject3;
              if ((localObject4 != null) && (this.b.acceptBusinessObject(localObject4)))
              {
                localObject2 = new MenuItem((Menu)localObject1, 64);
                ((MenuItem)localObject2).setText(this.a.c("paste.popup"));
                ((MenuItem)localObject2).addListener(13, new O(this, this.b, localObject4));
              }
            }
            if ((this.b.getBusinessObject() instanceof IBusinessObject))
            {
              localObject3 = ((IBusinessObject)this.b.getBusinessObject()).getContainer();
              if ((localObject3 instanceof ITreeNode))
              {
                localObject4 = localObject3;
                localObject2 = new MenuItem((Menu)localObject1, 64);
                ((MenuItem)localObject2).setText(this.a.c("finddefine.popup"));
                ((MenuItem)localObject2).addListener(13, new P(this, (ITreeNode)localObject4));
              }
            }
          }
          ((Menu)localObject1).setEnabled(true);
          ((Menu)localObject1).setVisible(true);
        }
        else
        {
          localObject1 = h.a();
          if (this.a.f().size() > 0)
          {
            if (!this.b.isLocked())
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("cut.popup"));
              ((MenuItem)localObject2).addListener(13, new Q(this));
            }
            if (paramMouseEvent.button == 3)
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("copy.popup"));
              ((MenuItem)localObject2).addListener(13, new R(this));
            }
            if (!this.b.isLocked())
            {
              localObject2 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject2).setText(this.a.c("delete.popup"));
              ((MenuItem)localObject2).addListener(13, new S(this));
            }
          }
          else if ((paramMouseEvent.button == 3) && (!this.b.isLocked()))
          {
            localObject2 = new Clipboard(Display.getCurrent()).getContents(d.a());
            if ((localObject2 == null) || (!(localObject2 instanceof IElement)))
              localObject2 = new Clipboard(Display.getCurrent()).getContents(TextTransfer.getInstance());
            localObject3 = localObject2;
            if ((localObject3 != null) && (this.b.acceptBusinessObject(localObject3)))
            {
              localObject4 = new MenuItem((Menu)localObject1, 64);
              ((MenuItem)localObject4).setText(this.a.c("paste.popup"));
              ((MenuItem)localObject4).addListener(13, new K(this, this.b, localObject3));
            }
          }
          ((Menu)localObject1).setEnabled(true);
          ((Menu)localObject1).setVisible(true);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.a.a.g();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.I
 * JD-Core Version:    0.6.0
 */