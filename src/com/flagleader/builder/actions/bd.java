package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Iterator;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;

public class bd
{
  private BuilderManager b;
  private boolean c = false;
  private ITreeNode d;

  public bd(aO paramaO, BuilderManager paramBuilderManager)
  {
    this.b = paramBuilderManager;
  }

  public void a(TreeItem paramTreeItem)
  {
    this.c = false;
    if ((paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof ITreeNode)))
      this.d = ((ITreeNode)paramTreeItem.getData());
    String str = ((ITreeNode)paramTreeItem.getData()).getName() + ".popupMenu";
    try
    {
      aO.a(this.a, h.a());
      String[] arrayOfString = ResourceTools.getConfigArray(str);
      for (int i = 0; i < arrayOfString.length; i++)
        if (arrayOfString[i].equals("-"))
        {
          if (this.c)
            a(aO.a(this.a));
          this.c = false;
        }
        else
        {
          a(aO.a(this.a), arrayOfString[i]);
        }
      aO.a(this.a).setEnabled(true);
      aO.a(this.a).setVisible(true);
    }
    catch (SWTError localSWTError)
    {
      this.b.getRuleEditor().g();
    }
  }

  private MenuItem a(Menu paramMenu)
  {
    return new MenuItem(paramMenu, 2);
  }

  private void a(Menu paramMenu, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (ResourceTools.getConfigArray(paramString + ".menu") != null)
    {
      localObject1 = new MenuItem(paramMenu, 64);
      ((MenuItem)localObject1).setMenu(new Menu((MenuItem)localObject1));
      ((MenuItem)localObject1).setText(ResourceTools.getMessage(paramString));
      localObject2 = ResourceTools.getConfigArray(paramString + ".menu");
      for (int i = 0; i < localObject2.length; i++)
        if (localObject2[i].equals("-"))
        {
          if (this.c)
            a(((MenuItem)localObject1).getMenu());
          this.c = false;
        }
        else
        {
          a(((MenuItem)localObject1).getMenu(), localObject2[i]);
        }
      if (((paramString.equals("packageadd")) || (paramString.equals("templateadd"))) && (this.d != null) && ((this.d instanceof IRuleSet)))
      {
        Envionment localEnvionment = ((IRuleSet)this.d).getEnvionment();
        a(((MenuItem)localObject1).getMenu());
        Iterator localIterator = localEnvionment.getAcceptElements(new be(this));
        while (localIterator.hasNext())
        {
          IRuleTree localIRuleTree = (IRuleTree)localIterator.next();
          MenuItem localMenuItem = new MenuItem(((MenuItem)localObject1).getMenu(), 8);
          localMenuItem.setText(localIRuleTree.getVisitRuleName());
          localMenuItem.setImage(ResourceTools.getIcon(localIRuleTree));
          bf tmp285_282 = this.b.getListenersManager();
          tmp285_282.getClass();
          localMenuItem.addSelectionListener(new bg(tmp285_282, (IRuleSet)this.d, localIRuleTree));
        }
      }
    }
    else
    {
      localObject1 = null;
      if (ResourceTools.getStringValue(paramString + ".listener") != null)
        localObject1 = this.b.getListenersManager().a(ResourceTools.getStringValue(paramString + ".listener"));
      if ((localObject1 != null) && (((bi)localObject1).a(this.d)))
      {
        localObject2 = new MenuItem(paramMenu, 8);
        if (ResourceTools.getMessage(paramString) != null)
          ((MenuItem)localObject2).setText(ResourceTools.getMessage(paramString));
        if (ResourceTools.getStringValue(paramString + ".icon") != null)
          ((MenuItem)localObject2).setImage(ResourceTools.getImage(paramString + ".icon"));
        ((MenuItem)localObject2).addSelectionListener((SelectionListener)localObject1);
        this.c = true;
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bd
 * JD-Core Version:    0.6.0
 */