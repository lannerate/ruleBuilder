package com.flagleader.builder.actions;

import com.flagleader.builder.ResourceTools;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

abstract class h extends Action
{
  protected String c = null;

  public h(ActionsManager paramActionsManager, String paramString)
  {
    this.c = paramString;
    if (ResourceTools.getMessage(paramString) != null)
      setText(ResourceTools.getMessage(paramString));
    if (ResourceTools.getStringValue(paramString + ".icon") != null)
    {
      ImageDescriptor localImageDescriptor = ResourceTools.getImageDescriptor(paramString + ".icon");
      if (localImageDescriptor != null)
      {
        setImageDescriptor(localImageDescriptor);
        setDisabledImageDescriptor(ImageDescriptor.createWithFlags(localImageDescriptor, 1));
      }
    }
    if (ResourceTools.getMessage(paramString + ".tip") != null)
      setToolTipText(ResourceTools.getMessage(paramString + ".tip"));
    else if (ResourceTools.getMessage(paramString) != null)
      setToolTipText(ResourceTools.getMessage(paramString).replace('@', '\t'));
    setId(paramString);
    setEnabled(true);
  }

  protected boolean a()
  {
    return true;
  }

  public boolean isEnabled()
  {
    return super.isEnabled();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h
 * JD-Core Version:    0.6.0
 */