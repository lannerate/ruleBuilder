package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.q;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class al
  implements Observer
{
  private IMenuManager a = null;
  private IMenuManager b = null;
  private IMenuManager c;
  private IMenuManager d;
  private IToolBarManager e;
  private BuilderManager f;
  private q g;
  private boolean h = true;

  public al(BuilderManager paramBuilderManager)
  {
    this.f = paramBuilderManager;
  }

  public void a(IMenuManager paramIMenuManager)
  {
    String[] arrayOfString = ResourceTools.getConfigArray("MenuBar");
    this.c = paramIMenuManager;
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localObject = new MenuManager(ResourceTools.getMessage(arrayOfString[i]), arrayOfString[i]);
      paramIMenuManager.add((IContributionItem)localObject);
      b((IMenuManager)localObject, arrayOfString[i]);
      ((MenuManager)localObject).addMenuListener(new ap(this, (IMenuManager)localObject));
      if (arrayOfString[i].equalsIgnoreCase("EditMenu"))
        this.a = ((IMenuManager)localObject);
      if (!arrayOfString[i].equalsIgnoreCase("FileMenu"))
        continue;
      this.b = ((IMenuManager)localObject);
    }
    Display localDisplay = Display.getCurrent();
    Object localObject = new am(this);
    localDisplay.timerExec(1000, (Runnable)localObject);
  }

  public void b(IMenuManager paramIMenuManager)
  {
    if (paramIMenuManager != null)
    {
      IContributionItem[] arrayOfIContributionItem = paramIMenuManager.getItems();
      for (int i = 0; i < arrayOfIContributionItem.length; i++)
        arrayOfIContributionItem[i].update("enabled");
    }
  }

  public void a(IMenuManager paramIMenuManager, String paramString)
  {
    String[] arrayOfString1 = ResourceTools.getConfigArray(paramString);
    for (int i = 0; i < arrayOfString1.length; i++)
      if (arrayOfString1[i].equals("-"))
      {
        d(paramIMenuManager);
      }
      else
      {
        paramIMenuManager.remove(arrayOfString1[i]);
        if (ResourceTools.getConfigArray(arrayOfString1[i]) != null)
        {
          localObject = new MenuManager(ResourceTools.getMessage(arrayOfString1[i]), arrayOfString1[i]);
          paramIMenuManager.add((IContributionItem)localObject);
          String[] arrayOfString2 = ResourceTools.getConfigArray(arrayOfString1[i]);
          for (int j = 0; j < arrayOfString2.length; j++)
            c((IMenuManager)localObject, arrayOfString2[j]);
        }
        else
        {
          c(paramIMenuManager, arrayOfString1[i]);
        }
      }
    Display localDisplay = Display.getCurrent();
    Object localObject = new an(this);
    localDisplay.timerExec(1000, (Runnable)localObject);
  }

  public void b(IMenuManager paramIMenuManager, String paramString)
  {
    String[] arrayOfString = ResourceTools.getConfigArray(paramString);
    for (int i = 0; i < arrayOfString.length; i++)
      if (arrayOfString[i].equals("-"))
      {
        d(paramIMenuManager);
      }
      else
      {
        MenuManager localMenuManager;
        Object localObject;
        if (arrayOfString[i].equals("recentProject"))
        {
          localMenuManager = new MenuManager(ResourceTools.getMessage(arrayOfString[i]), "recentProject");
          paramIMenuManager.add(localMenuManager);
          localMenuManager.addMenuListener(new ao(this, localMenuManager));
          localObject = this.f.getRulesManager().d();
          if (localObject == null)
            continue;
          List localList = ((IRuleRepository)localObject).getClosedNode();
          if (localList.size() <= 0)
            continue;
          for (int k = 0; k < localList.size(); k++)
          {
            if (!(localList.get(k) instanceof RuleProject))
              continue;
            ActionsManager tmp155_152 = this.f.getActionsManager();
            tmp155_152.getClass();
            localMenuManager.add(new N(tmp155_152, (RuleProject)localList.get(k)));
          }
        }
        else
        {
          if (arrayOfString[i].equals("recentPackage"))
            continue;
          if (ResourceTools.getConfigArray(arrayOfString[i]) != null)
          {
            localMenuManager = new MenuManager(ResourceTools.getMessage(arrayOfString[i]));
            paramIMenuManager.add(localMenuManager);
            localObject = ResourceTools.getConfigArray(arrayOfString[i]);
            for (int j = 0; j < localObject.length; j++)
              c(localMenuManager, localObject[j]);
          }
          else
          {
            c(paramIMenuManager, arrayOfString[i]);
          }
        }
      }
  }

  private void c(IMenuManager paramIMenuManager)
  {
    if (paramIMenuManager.getId().equals("ViewMenu"))
    {
      this.f.getActionsManager().getAction("MessageWindowItem").setChecked(this.f.getWindowsManager().i());
      this.f.getActionsManager().getAction("EditWindowItem").setChecked(this.f.getWindowsManager().g());
      this.f.getActionsManager().getAction("PropsWindowItem").setChecked(this.f.getWindowsManager().h());
      this.f.getActionsManager().getAction("ProjectViewerItem").setChecked(this.f.getWindowsManager().j());
      b(paramIMenuManager);
    }
    else if (paramIMenuManager.getId().equals("FileMenu"))
    {
      b(paramIMenuManager);
    }
    else
    {
      b(paramIMenuManager);
    }
  }

  private void c(IMenuManager paramIMenuManager, String paramString)
  {
    Action localAction = this.f.getActionsManager().getAction(paramString);
    if (localAction != null)
      paramIMenuManager.add(localAction);
  }

  public IToolBarManager a(IToolBarManager paramIToolBarManager)
  {
    this.e = paramIToolBarManager;
    String[] arrayOfString = ResourceTools.getConfigArray("ToolBar");
    for (int i = 0; i < arrayOfString.length; i++)
      if (arrayOfString[i].equals("-"))
        c(this.e);
      else
        this.e.add(this.f.getActionsManager().getAction(arrayOfString[i]));
    return this.e;
  }

  public IToolBarManager b(IToolBarManager paramIToolBarManager)
  {
    this.e = paramIToolBarManager;
    String[] arrayOfString = ResourceTools.getConfigArray("ToolBar");
    for (int i = 0; i < arrayOfString.length; i++)
      if (arrayOfString[i].equals("-"))
      {
        c(this.e);
      }
      else
      {
        this.e.remove(arrayOfString[i]);
        this.e.add(this.f.getActionsManager().getAction(arrayOfString[i]));
      }
    return this.e;
  }

  public IToolBarManager a()
  {
    return this.e;
  }

  private static void d(IMenuManager paramIMenuManager)
  {
    paramIMenuManager.add(new Separator());
  }

  private static void c(IToolBarManager paramIToolBarManager)
  {
    paramIToolBarManager.add(new Separator());
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    this.h = false;
  }

  public void b()
  {
    IContributionItem[] arrayOfIContributionItem = this.e.getItems();
    for (int i = 0; i < arrayOfIContributionItem.length; i++)
      arrayOfIContributionItem[i].update("enabled");
    b(this.a);
    b(this.b);
    this.f.updateEditor();
  }

  public boolean c()
  {
    if (this.f.getRulesManager().d() == null)
      return false;
    return this.f.getRulesManager().d().isModified();
  }

  public boolean d()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
        return false;
      if ((localControl instanceof StyledText))
        return false;
      if ((localControl instanceof Combo))
        return false;
      if ((localControl instanceof CCombo))
        return false;
    }
    IElementViewer localIElementViewer = this.f.getRuleEditor().e();
    return (localIElementViewer != null) && (localIElementViewer.canUndo());
  }

  public boolean e()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
        return false;
      if ((localControl instanceof StyledText))
        return false;
      if ((localControl instanceof Combo))
        return false;
      if ((localControl instanceof CCombo))
        return false;
    }
    IElementViewer localIElementViewer = this.f.getRuleEditor().e();
    return (localIElementViewer != null) && (localIElementViewer.canRedo());
  }

  public boolean f()
  {
    if (this.f.getProjectTree().c() == null)
      return false;
    return ((this.f.getProjectTree().c() instanceof RulePackage)) || ((this.f.getProjectTree().c() instanceof IPage)) || ((this.f.getProjectTree().c() instanceof IRuleProject)) || ((this.f.getProjectTree().c() instanceof IRuleGroup));
  }

  public boolean g()
  {
    if (this.f.getProjectTree().c() == null)
      return false;
    if ((this.f.getProjectTree().c() instanceof RulePackage))
    {
      if ((((RulePackage)this.f.getProjectTree().c()).getParent() != null) && (((RulePackage)this.f.getProjectTree().c()).getParent().isLocked()))
        return false;
      if ((((RulePackage)this.f.getProjectTree().c()).isCheckOut()) || (!((RulePackage)this.f.getProjectTree().c()).isLocked()))
        return true;
    }
    return ((this.f.getProjectTree().c() instanceof IRuleProject)) && (!((IRuleProject)this.f.getProjectTree().c()).isLocked());
  }

  public boolean h()
  {
    if (this.f.getProjectTree().c() == null)
      return false;
    if ((this.f.getProjectTree().c() instanceof RulePackage))
    {
      if ((((RulePackage)this.f.getProjectTree().c()).getParent() != null) && (((RulePackage)this.f.getProjectTree().c()).getParent().isLocked()))
        return false;
      if ((((RulePackage)this.f.getProjectTree().c()).isCheckIn()) || (((RulePackage)this.f.getProjectTree().c()).isLocked()))
        return true;
    }
    return ((this.f.getProjectTree().c() instanceof IRuleProject)) && (!((IRuleProject)this.f.getProjectTree().c()).isLocked());
  }

  public q i()
  {
    return this.g;
  }

  public void a(q paramq)
  {
    this.g = paramq;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.al
 * JD-Core Version:    0.6.0
 */