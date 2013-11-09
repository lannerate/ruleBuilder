package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.b.o;
import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.widget.p;
import com.flagleader.manager.c.c.d;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.c.c.g;
import com.flagleader.manager.d.b;
import com.flagleader.repository.rlm.action.PackCatchActionToken;
import com.flagleader.repository.rlm.condition.RuleLogConditionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class l extends MouseAdapter
{
  l(k paramk)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = com.flagleader.builder.widget.h.a();
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup"));
      localMenuItem.addListener(13, new m(this));
      localMenu.setVisible(true);
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (this.a.f())
      return;
    if (((this.a.d() instanceof IRuleTree)) && (!((IRuleTree)this.a.d()).isDevelopModel()) && (((IRuleTree)this.a.d()).getVml() != 0))
      return;
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = k.a(this.a).getItem(localPoint);
    if ((localTableItem == null) || (localTableItem.isDisposed()))
      return;
    k.a(this.a, localTableItem);
    if (!localTableItem.getBounds(1).contains(localPoint))
      return;
    Object localObject1 = localTableItem.getData("monitor");
    Object localObject2;
    Object localObject4;
    Object localObject5;
    Object localObject3;
    String str1;
    if (localObject1 != null)
    {
      if ((localObject1 instanceof f))
      {
        localObject2 = new p(this.a.c()).a(k.a(this.a), 4);
        ((Text)localObject2).setFont(k.a(this.a).getFont());
        ((Text)localObject2).setText(localTableItem.getText(1));
        if ((localTableItem.getData("type") != null) && (localTableItem.getData("type").toString().equals("passwd")))
          ((Text)localObject2).setEchoChar('*');
        k.a(this.a, localTableItem, (Text)localObject2, k.b(this.a), 1, (f)localObject1);
        ((Text)localObject2).setFocus();
        return;
      }
      if ((localObject1 instanceof e))
      {
        localObject2 = new CCombo(k.a(this.a), 8);
        k.a(this.a, localTableItem, (CCombo)localObject2, k.b(this.a), 1, (e)localObject1);
        ((CCombo)localObject2).setFocus();
        return;
      }
      if ((localObject1 instanceof g))
      {
        localObject2 = new CCombo(k.a(this.a), 0);
        k.a(this.a, localTableItem, (CCombo)localObject2, k.b(this.a), 1, (g)localObject1);
        ((CCombo)localObject2).setFocus();
        return;
      }
      if ((localObject1 instanceof com.flagleader.manager.c.c.a))
      {
        localObject2 = (com.flagleader.manager.c.c.a)localObject1;
        int i = ((com.flagleader.manager.c.c.a)localObject2).a();
        localObject4 = ((com.flagleader.manager.c.c.a)localObject2).c();
        localObject5 = new M(localTableItem.getText(1), i, (com.flagleader.manager.c.a)localObject4);
        if ((((M)localObject5).open() == 0) && (!this.a.d.isLocked()) && (!this.a.f()) && (!localTableItem.getText(1).equals(((M)localObject5).a())))
        {
          ((com.flagleader.manager.c.c.a)localObject2).a(((M)localObject5).a());
          this.a.update();
        }
        return;
      }
      if ((localObject1 instanceof d))
      {
        localObject2 = (d)localObject1;
        localObject3 = new FileDialog(k.a(this.a).getShell(), 4096);
        ((FileDialog)localObject3).setFilterExtensions(((d)localObject2).b());
        localObject4 = ((d)localObject2).a();
        if ((localObject4 != null) && (((String)localObject4).length() > 0))
        {
          localObject5 = new File((String)localObject4).getParent();
          str1 = new File((String)localObject4).getName();
          ((FileDialog)localObject3).setFilterPath((String)localObject5);
          ((FileDialog)localObject3).setFileName(str1);
        }
        ((d)localObject2).a(((FileDialog)localObject3).open());
        this.a.update();
        return;
      }
    }
    if ((localTableItem.getData("type") != null) && (localTableItem.getData("type").toString().equals("logic")) && (!this.a.d.isLocked()))
    {
      if ((!this.a.f()) && (localTableItem.getData("condition") != null) && ((localTableItem.getData("condition") instanceof IMultiConditionToken)))
      {
        localObject2 = new o(this.a.b.i().getShell(), this.a.b.i(), (RuleLogConditionToken)localTableItem.getData("condition"));
        if (((o)localObject2).open() == 0)
          this.a.update();
      }
      return;
    }
    if ((localTableItem.getData("type") != null) && (localTableItem.getData("type").toString().equals("catch")) && (!this.a.d.isLocked()))
    {
      if ((!this.a.f()) && (localTableItem.getData("catch") != null) && ((localTableItem.getData("catch") instanceof PackCatchActionToken)))
      {
        localObject2 = new com.flagleader.builder.b.a(this.a.b.i().getShell(), this.a.b.i(), (PackCatchActionToken)localTableItem.getData("catch"));
        if (((com.flagleader.builder.b.a)localObject2).open() == 0)
          this.a.update();
      }
      return;
    }
    if ((localTableItem.getData("type") != null) && (localTableItem.getData("type").toString().equals("file")) && (!this.a.d.isLocked()))
    {
      localObject2 = new FileDialog(k.a(this.a).getShell(), 4096);
      localObject3 = this.a.b.i().getConfigManager().a + File.separator + "templates";
      ((FileDialog)localObject2).setFilterExtensions(new String[] { "*.*" });
      localObject4 = localTableItem.getData("value").toString();
      localObject5 = new File((String)localObject4).getParent();
      str1 = new File((String)localObject4).getName();
      if (!new File((String)localObject4).exists())
      {
        str2 = "";
        if (((String)localObject4).lastIndexOf("/") > 0)
          str2 = ((String)localObject4).substring(0, ((String)localObject4).lastIndexOf("/"));
        localObject5 = localObject3 + File.separator + str2;
      }
      ((FileDialog)localObject2).setFilterPath((String)localObject5);
      ((FileDialog)localObject2).setFileName(str1);
      String str2 = ((FileDialog)localObject2).open();
      if ((str2 != null) && (!new File((String)localObject5, str1).getPath().equalsIgnoreCase(str2)))
      {
        String str3 = str2;
        if (str2.indexOf((String)localObject3) >= 0)
        {
          str3 = str2.substring(((String)localObject3).length() + 1);
          str3 = str3.replace(File.separatorChar, '/');
        }
        h localh = (h)localTableItem.getData("action");
        if ((!this.a.f()) && (localh.a(str3)))
        {
          this.a.update();
          return;
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.l
 * JD-Core Version:    0.6.0
 */